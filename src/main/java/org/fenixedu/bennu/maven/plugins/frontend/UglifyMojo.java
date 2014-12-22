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

@Mojo(name = "uglify", requiresDependencyResolution = ResolutionScope.TEST, threadSafe = true)
@Execute(phase = LifecyclePhase.GENERATE_RESOURCES)
public final class UglifyMojo extends AbstractMojo {

    @Parameter(defaultValue = "${basedir}", property = "workingDirectory", required = false)
    private File workingDirectory;

    @Parameter(defaultValue = "${basedir}", property = "sourceFile", required = false)
    private File sourceFile;

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
            new FrontendPluginFactory(workingDirectory).getUglifyInstaller().install();
            new FrontendPluginFactory(workingDirectory).getUglifyRunner().execute(arguments, sourceFile);
        } catch (InstallationException | TaskRunnerException e) {
            e.printStackTrace();
        }
    }

}
