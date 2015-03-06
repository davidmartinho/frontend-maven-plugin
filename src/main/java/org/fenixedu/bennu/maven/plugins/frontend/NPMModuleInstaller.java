package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;
import java.util.Arrays;

import org.fenixedu.bennu.maven.plugins.frontend.exception.TaskRunnerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class NPMModuleInstaller extends NodeTaskExecutor {

    private static final String TASK_NAME = "npm install";
    private static final String TASK_LOCATION = "/node/npm/bin/npm-cli.js";

    private Logger logger = LoggerFactory.getLogger(getClass());
    private String moduleName;

    public NPMModuleInstaller(String moduleName, File workingDirectory, Platform platform) {
        super(TASK_NAME, TASK_LOCATION, workingDirectory, platform, Arrays.asList("install", moduleName));
        this.moduleName = moduleName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void install() throws TaskRunnerException {
        if (moduleIsInstalled()) {
            logger.info("Skipping installation of browserify because it's already installed in {}", moduleName);
        } else {
            execute();
        }
    }

    private File getModuleDir() {
        return new File(getWorkingDirectory().getAbsolutePath() + "/node_modules/" + moduleName);
    }

    private boolean moduleIsInstalled() {
        return getModuleDir().exists();
    }

}
