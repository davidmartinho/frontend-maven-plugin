package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultDebowerifyInstaller extends NodeTaskExecutor implements DebowerifyInstaller {

    private static final Logger logger = LoggerFactory.getLogger(DefaultDebowerifyInstaller.class);

    public DefaultDebowerifyInstaller(Platform platform, File workingDirectory) {
        super(TASK_NAME, TASK_LOCATION, workingDirectory, platform, new ArrayList<String>());
    }

    @Override
    public void install() throws TaskRunnerException {
        File debowerifyFolder = new File(getWorkingDirectory().getAbsolutePath() + "/node_modules/debowerify");
        if (debowerifyFolder.exists()) {
            logger.info("Skipping installation of debowerify because it's already installed in {}",
                    debowerifyFolder.getAbsolutePath());
        } else {
            super.execute("install debowerify");
        }
    }
}
