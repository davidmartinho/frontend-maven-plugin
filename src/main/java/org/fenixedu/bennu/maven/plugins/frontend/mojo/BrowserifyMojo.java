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

@Mojo(name = "browserify", defaultPhase = LifecyclePhase.GENERATE_SOURCES, requiresDependencyResolution = ResolutionScope.TEST,
        threadSafe = true)
public class BrowserifyMojo extends AbstractMojo {

    @Parameter(defaultValue = "${basedir}", property = "workingDirectory", required = false)
    protected File workingDirectory;

    @Parameter(defaultValue = "${basedir}", property = "sourceFile", required = false)
    protected File sourceFile;

    @Parameter(defaultValue = "${basedir}", property = "outputFile", required = false)
    protected File outputFile;

    @Parameter(property = "vendorsSourceFile", required = false)
    protected File vendorsSourceFile;

    @Parameter(defaultValue = "${basedir}", property = "vendorsOutputFile", required = false)
    protected File vendorsOutputFile;

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
        FrontendPluginFactory pluginFactory = new FrontendPluginFactory(workingDirectory);
        try {

            pluginFactory.getBowerInstaller().install();
            pluginFactory.getDebowerifyInstaller().install();
            pluginFactory.getBowerRunner().execute(arguments);
            pluginFactory.getBrowserifyInstaller().install();

            // Run browserify for vendors
            if (vendorsSourceFile != null && vendorsOutputFile != null) {
                pluginFactory.getBrowserifyRunner().execute(arguments, vendorsSourceFile, vendorsOutputFile);
            }

            pluginFactory.getBrowserifyRunner().execute(arguments, sourceFile, outputFile);
        } catch (TaskRunnerException e) {
            throw new MojoExecutionException("Could not execute browserify goal", e);
        }
    }
}
