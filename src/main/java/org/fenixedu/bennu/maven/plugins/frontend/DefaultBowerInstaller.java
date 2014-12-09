package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultBowerInstaller extends NodeTaskExecutor implements BowerInstaller {

    private static final Logger logger = LoggerFactory.getLogger(DefaultBowerInstaller.class);

    public DefaultBowerInstaller(Platform platform, File workingDirectory) {
        super(TASK_NAME, TASK_LOCATION, workingDirectory, platform, Arrays.asList(""));
    }

    @Override
    public void install() throws TaskRunnerException {
        File bowerFolder = new File(getWorkingDirectory().getAbsolutePath() + "/node_modules/bower");
        if (bowerFolder.exists()) {
            logger.info("Skipping installation of bower because it's already installed in {}", bowerFolder.getAbsolutePath());
        } else {
            super.execute("install bower");
        }
    }
}
