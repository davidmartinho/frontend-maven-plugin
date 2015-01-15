package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;
import java.util.Arrays;

import org.fenixedu.bennu.maven.plugins.frontend.exception.TaskRunnerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultWatchifyInstaller extends NodeTaskExecutor implements WatchifyInstaller {

    private static final Logger logger = LoggerFactory.getLogger(DefaultWatchifyInstaller.class);

    public DefaultWatchifyInstaller(Platform platform, File workingDirectory) {
        super(TASK_NAME, TASK_LOCATION, workingDirectory, platform, Arrays.asList(""));
    }

    @Override
    public void install() throws TaskRunnerException {
        File watchifyFolder = new File(getWorkingDirectory().getAbsolutePath() + "/node_modules/watchify");
        if (watchifyFolder.exists()) {
            logger.info("Skipping installation of watchify because it's already installed in {}",
                    watchifyFolder.getAbsolutePath());
        } else {
            super.execute("install watchify");
        }

    }

}
