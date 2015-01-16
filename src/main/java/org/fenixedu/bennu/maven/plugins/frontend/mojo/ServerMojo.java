package org.fenixedu.bennu.maven.plugins.frontend.mojo;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.tomcat.maven.plugin.tomcat7.run.RunMojo;
import org.fenixedu.bennu.maven.plugins.frontend.FrontendPluginFactory;

@Mojo(name = "server", requiresDependencyResolution = ResolutionScope.TEST, threadSafe = true)
public final class ServerMojo extends RunMojo {

    @Parameter(defaultValue = "${basedir}", property = "workingDirectory", required = false)
    private File workingDirectory;

    @Parameter(defaultValue = "${basedir}", property = "sourceFile", required = false)
    private File sourceFile;

    @Parameter(defaultValue = "${basedir}", property = "outputFile", required = false)
    private File outputFile;

    @Parameter(property = "arguments")
    private String arguments;

    @Parameter(property = "nodeVersion", defaultValue = "v0.10.18")
    private String nodeVersion;

    @Parameter(property = "npmVersion", defaultValue = "1.3.8")
    private String npmVersion;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        BrowserifyAndWatchifyRunner runner = new BrowserifyAndWatchifyRunner(this);
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Void> future = executor.submit(runner);
        executor.shutdown();
        super.execute();
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new MojoExecutionException("Could not run browserify or watchify", e);
        }
    }

    public class BrowserifyAndWatchifyRunner implements Callable<Void> {

        private ServerMojo serverMojo;

        public BrowserifyAndWatchifyRunner(ServerMojo serverMojo) {
            this.serverMojo = serverMojo;
        }

        @Override
        public Void call() throws Exception {
            MojoUtils.setSLF4jLogger(serverMojo.getLog());
            new FrontendPluginFactory(serverMojo.workingDirectory).getNodeAndNPMInstaller().install(nodeVersion, npmVersion);
            new FrontendPluginFactory(serverMojo.workingDirectory).getBrowserifyInstaller().install();
            new FrontendPluginFactory(serverMojo.workingDirectory).getDebowerifyInstaller().install();
            new FrontendPluginFactory(serverMojo.workingDirectory).getWatchifyInstaller().install();
            new FrontendPluginFactory(serverMojo.workingDirectory).getBrowserifyRunner().execute(arguments, sourceFile,
                    outputFile);
            new FrontendPluginFactory(serverMojo.workingDirectory).getWatchifyRunner().execute(arguments, sourceFile, outputFile);
            return null;
        }
    }

}
