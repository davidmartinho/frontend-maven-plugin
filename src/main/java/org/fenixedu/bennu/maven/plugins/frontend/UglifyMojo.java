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
@Execute(phase = LifecyclePhase.PROCESS_RESOURCES)
public final class UglifyMojo extends AbstractMojo {

    @Parameter(defaultValue = "${basedir}", property = "workingDirectory", required = false)
    protected File workingDirectory;

    @Parameter(defaultValue = "${basedir}", property = "sourceFile", required = false)
    protected File sourceFile;

    @Parameter(defaultValue = "${basedir}", property = "vendorsSourceFile", required = false)
    protected File vendorsSourceFile;

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
            FrontendPluginFactory frontendPluginFactory = new FrontendPluginFactory(workingDirectory);
            frontendPluginFactory.getUglifyInstaller().install();
            if (vendorsSourceFile != null) {
                frontendPluginFactory.getUglifyRunner().execute(arguments, vendorsSourceFile);
            }
            frontendPluginFactory.getUglifyRunner().execute(arguments, sourceFile);
        } catch (TaskRunnerException e) {
            e.printStackTrace();
        }
    }

}
