package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;
import java.util.Arrays;

import org.fenixedu.bennu.maven.plugins.frontend.exception.TaskRunnerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultBrowserifyInstaller extends NodeTaskExecutor implements BrowserifyInstaller {

    private static final Logger logger = LoggerFactory.getLogger(DefaultBrowserifyInstaller.class);

    public DefaultBrowserifyInstaller(Platform platform, File workingDirectory) {
        super(TASK_NAME, TASK_LOCATION, workingDirectory, platform, Arrays.asList(""));
    }

    @Override
    public void install() throws TaskRunnerException {
        File browserifyFolder = new File(getWorkingDirectory().getAbsolutePath() + "/node_modules/browserify");
        if (browserifyFolder.exists()) {
            logger.info("Skipping installation of browserify because it's already installed in {}",
                    browserifyFolder.getAbsolutePath());
        } else {
            super.execute("install browserify");
        }
    }
}
