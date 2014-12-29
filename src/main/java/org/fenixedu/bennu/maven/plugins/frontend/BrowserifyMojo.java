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
@Execute(phase = LifecyclePhase.GENERATE_SOURCES)
public class BrowserifyMojo extends AbstractMojo {

    @Parameter(defaultValue = "${basedir}", property = "workingDirectory", required = false)
    protected File workingDirectory;

    @Parameter(defaultValue = "${basedir}", property = "sourceFile", required = false)
    protected File sourceFile;

    @Parameter(defaultValue = "${basedir}", property = "outputFile", required = false)
    protected File outputFile;

    @Parameter(property = "nodeVersion", defaultValue = "v0.10.18")
    protected String nodeVersion;

    @Parameter(property = "npmVersion", defaultValue = "1.3.8")
    protected String npmVersion;

    @Parameter(property = "arguments")
    protected String arguments;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        MojoUtils.setSLF4jLogger(getLog());
        try {
            new FrontendPluginFactory(workingDirectory).getNodeAndNPMInstaller().install(nodeVersion, npmVersion);
            new FrontendPluginFactory(workingDirectory).getNPMRunner().execute(arguments);
            new FrontendPluginFactory(workingDirectory).getBowerInstaller().install();
            new FrontendPluginFactory(workingDirectory).getBowerRunner().execute(arguments);
            new FrontendPluginFactory(workingDirectory).getBrowserifyInstaller().install();
            new FrontendPluginFactory(workingDirectory).getBrowserifyRunner().execute(arguments, sourceFile, outputFile);
        } catch (InstallationException | TaskRunnerException e) {
            e.printStackTrace();
        }
    }

}
