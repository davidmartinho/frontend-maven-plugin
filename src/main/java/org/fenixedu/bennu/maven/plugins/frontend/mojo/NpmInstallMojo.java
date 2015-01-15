package org.fenixedu.bennu.maven.plugins.frontend.mojo;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Execute;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.fenixedu.bennu.maven.plugins.frontend.FrontendPluginFactory;
import org.fenixedu.bennu.maven.plugins.frontend.exception.TaskRunnerException;

@Mojo(name = "npm", requiresDependencyResolution = ResolutionScope.TEST, threadSafe = true)
@Execute(phase = LifecyclePhase.GENERATE_SOURCES)
public class NpmInstallMojo extends AbstractMojo {

    @Parameter(defaultValue = "${basedir}", property = "workingDirectory", required = false)
    protected File workingDirectory;

    @Parameter(property = "arguments")
    protected String arguments;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        MojoUtils.setSLF4jLogger(getLog());
        try {
            FrontendPluginFactory pluginFactory = new FrontendPluginFactory(workingDirectory);
            pluginFactory.getNPMRunner().execute(arguments);
        } catch (TaskRunnerException e) {
            e.printStackTrace();
        }
    }
}
