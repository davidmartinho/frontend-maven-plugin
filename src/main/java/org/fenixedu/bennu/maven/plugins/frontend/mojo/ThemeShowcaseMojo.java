package org.fenixedu.bennu.maven.plugins.frontend.mojo;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.fenixedu.bennu.maven.plugins.frontend.FrontendPluginFactory;
import org.fenixedu.bennu.maven.plugins.frontend.exception.TaskRunnerException;

@Mojo(name = "theme-showcase", requiresDependencyResolution = ResolutionScope.TEST, threadSafe = true)
public class ThemeShowcaseMojo extends AbstractMojo {

    @Parameter(defaultValue = "${basedir}", property = "workingDirectory", required = false)
    protected File workingDirectory;

    @Parameter(property = "path", defaultValue = "${basedir}/src/main/theme/")
    protected String path;

    @Parameter(property = "port", defaultValue = "9000")
    protected String port;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        MojoUtils.setSLF4jLogger(getLog());
        FrontendPluginFactory pluginFactory = new FrontendPluginFactory(workingDirectory);
        try {
            pluginFactory.getHttpServerInstaller().install();
            pluginFactory.getHttpServerRunner().execute(path, port);
        } catch (TaskRunnerException e) {
            throw new MojoExecutionException("Could not run theme-showcase goal", e);
        }
    }

}
