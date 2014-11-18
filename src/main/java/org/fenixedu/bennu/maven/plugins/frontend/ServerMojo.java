package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Execute;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.tomcat.maven.plugin.tomcat7.run.RunMojo;

@Mojo(name = "server", requiresDependencyResolution = ResolutionScope.TEST, threadSafe = true)
@Execute(phase = LifecyclePhase.PROCESS_CLASSES)
public final class ServerMojo extends RunMojo {

    @Parameter(defaultValue = "${basedir}/target", property = "workingDirectory", required = false)
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
        new NpmThread(this).start();
        super.execute();
    }

    public class NpmThread extends Thread {

        private ServerMojo serverMojo;

        public NpmThread(ServerMojo serverMojo) {
            super("NpmThread");
            this.serverMojo = serverMojo;
        }

        @Override
        public void run() {
            try {
                MojoUtils.setSLF4jLogger(serverMojo.getLog());
                new FrontendPluginFactory(serverMojo.workingDirectory).getNodeAndNPMInstaller().install(nodeVersion, npmVersion);
                new FrontendPluginFactory(serverMojo.workingDirectory).getBrowserifyInstaller().install();
                new FrontendPluginFactory(serverMojo.workingDirectory).getWatchifyInstaller().install();
                new FrontendPluginFactory(serverMojo.workingDirectory).getBrowserifyRunner().execute(arguments, sourceFile,
                        outputFile);
                new FrontendPluginFactory(serverMojo.workingDirectory).getWatchifyRunner().execute(arguments, sourceFile,
                        outputFile);
            } catch (TaskRunnerException e) {

            } catch (InstallationException e) {
            }

        }
    }

}
