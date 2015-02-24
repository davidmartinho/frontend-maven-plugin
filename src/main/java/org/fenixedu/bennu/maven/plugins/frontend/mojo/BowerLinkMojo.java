package org.fenixedu.bennu.maven.plugins.frontend.mojo;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.fenixedu.bennu.maven.plugins.frontend.FrontendPluginFactory;
import org.fenixedu.bennu.maven.plugins.frontend.exception.TaskRunnerException;

@Mojo(name = "bower-link", defaultPhase = LifecyclePhase.GENERATE_SOURCES, requiresDependencyResolution = ResolutionScope.TEST,
threadSafe = true)
public class BowerLinkMojo extends AbstractMojo {

    @Parameter(defaultValue = "${basedir}", property = "workingDirectory", required = false)
    protected File workingDirectory;

    @Parameter(property = "packageName")
    protected String packageName;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        MojoUtils.setSLF4jLogger(getLog());
        FrontendPluginFactory pluginFactory = new FrontendPluginFactory(workingDirectory);
        try {
            pluginFactory.getBowerInstaller().install();
            pluginFactory.getBowerLink().execute(packageName);
        } catch (TaskRunnerException e) {
            throw new MojoExecutionException("Could not run bower goal", e);
        }
    }
}
