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
import org.fenixedu.bennu.maven.plugins.frontend.exception.InstallationException;
import org.fenixedu.bennu.maven.plugins.frontend.exception.TaskRunnerException;

@Mojo(name = "install-node-and-npm-modules", requiresDependencyResolution = ResolutionScope.TEST, threadSafe = true)
@Execute(phase = LifecyclePhase.GENERATE_SOURCES)
public class InstallNodeAndNpmMojo extends AbstractMojo {

    @Parameter(defaultValue = "${basedir}", property = "workingDirectory", required = false)
    protected File workingDirectory;

    @Parameter(property = "nodeVersion", defaultValue = "v0.10.18")
    protected String nodeVersion;

    @Parameter(property = "npmVersion", defaultValue = "1.3.8")
    protected String npmVersion;

    @Parameter(property = "pythonPath", defaultValue = "/usr/bin/python2.7")
    protected String pythonPath;

    @Parameter(property = "arguments")
    protected String arguments;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        MojoUtils.setSLF4jLogger(getLog());
        try {
            FrontendPluginFactory pluginFactory = new FrontendPluginFactory(workingDirectory);
            pluginFactory.getNodeAndNPMInstaller().install(nodeVersion, npmVersion);
            pluginFactory.getNPMConfigurer(pythonPath).execute(arguments);
        } catch (InstallationException | TaskRunnerException e) {
            e.printStackTrace();
        }
    }
}
