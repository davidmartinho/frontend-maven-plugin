package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultUglifyInstaller extends NodeTaskExecutor implements UglifyInstaller {

    private static final Logger logger = LoggerFactory.getLogger(DefaultUglifyInstaller.class);

    public DefaultUglifyInstaller(Platform platform, File workingDirectory) {
        super(TASK_NAME, TASK_LOCATION, workingDirectory, platform, Arrays.asList(""));
    }

    @Override
    public void install() throws TaskRunnerException {
        File uglifyFolder = new File(getWorkingDirectory().getAbsolutePath() + "/node_modules/uglify-js");
        if (uglifyFolder.exists()) {
            logger.info("Skipping installation of uglify because it's already installed in {}", uglifyFolder.getAbsolutePath());
        } else {
            super.execute("install uglify-js");
        }
    }
}
