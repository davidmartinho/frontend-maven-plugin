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

@Mojo(name = "watchify", defaultPhase = LifecyclePhase.PROCESS_SOURCES, requiresDependencyResolution = ResolutionScope.TEST,
        threadSafe = true)
public class WatchifyMojo extends AbstractMojo {

    @Parameter(defaultValue = "${basedir}", property = "workingDirectory", required = false)
    protected File workingDirectory;

    @Parameter(defaultValue = "${basedir}", property = "sourceFile", required = false)
    protected File sourceFile;

    @Parameter(defaultValue = "${basedir}", property = "outputFile", required = false)
    protected File outputFile;

    @Parameter(property = "arguments")
    protected String arguments;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        MojoUtils.setSLF4jLogger(getLog());
        FrontendPluginFactory pluginFactory = new FrontendPluginFactory(workingDirectory);
        try {

            pluginFactory.getWatchifyInstaller().install();
            pluginFactory.getDebowerifyInstaller().install();

            pluginFactory.getWatchifyRunner().execute(arguments, sourceFile, outputFile);
        } catch (TaskRunnerException e) {
            throw new MojoExecutionException("Could not execute watchify goal", e);
        }
    }
}
