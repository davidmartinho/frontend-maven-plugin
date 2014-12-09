package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Execute;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;

@Mojo(name = "browserify", requiresDependencyResolution = ResolutionScope.TEST, threadSafe = true)
@Execute(phase = LifecyclePhase.COMPILE)
public final class BrowserifyMojo extends AbstractMojo {

    @Parameter(defaultValue = "${basedir}", property = "workingDirectory", required = false)
    private File workingDirectory;

    @Parameter(defaultValue = "${basedir}", property = "sourceFile", required = false)
    private File sourceFile;

    @Parameter(defaultValue = "${basedir}", property = "outputFile", required = false)
    private File outputFile;

    @Parameter(property = "nodeVersion", defaultValue = "v0.10.18")
    private String nodeVersion;

    @Parameter(property = "npmVersion", defaultValue = "1.3.8")
    private String npmVersion;

    @Parameter(property = "arguments")
    private String arguments;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        MojoUtils.setSLF4jLogger(getLog());
        try {
            new FrontendPluginFactory(workingDirectory).getNodeAndNPMInstaller().install(nodeVersion, npmVersion);
            new FrontendPluginFactory(workingDirectory).getBowerInstaller().install();
            new FrontendPluginFactory(workingDirectory).getBowerRunner().execute(arguments);
            new FrontendPluginFactory(workingDirectory).getBrowserifyInstaller().install();
            new FrontendPluginFactory(workingDirectory).getBrowserifyRunner().execute(arguments, sourceFile, outputFile);
        } catch (InstallationException | TaskRunnerException e) {
            e.printStackTrace();
        }
    }

}
