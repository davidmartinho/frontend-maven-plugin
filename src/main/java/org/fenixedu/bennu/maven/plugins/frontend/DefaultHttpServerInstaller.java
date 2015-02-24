package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;
import java.util.ArrayList;

import org.fenixedu.bennu.maven.plugins.frontend.exception.TaskRunnerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultHttpServerInstaller extends NodeTaskExecutor implements HttpServerInstaller {

    private static final Logger logger = LoggerFactory.getLogger(DefaultBowerInstaller.class);

    public DefaultHttpServerInstaller(Platform platform, File workingDirectory) {
        super(TASK_NAME, TASK_LOCATION, workingDirectory, platform, new ArrayList<String>());
    }

    @Override
    public void install() throws TaskRunnerException {
        File httpServerFolder = new File(getWorkingDirectory().getAbsolutePath() + "/node_modules/http-server");
        if (httpServerFolder.exists()) {
            logger.info("Skipping installation of http-server because it's already installed in {}",
                    httpServerFolder.getAbsolutePath());
        } else {
            super.execute("install http-server");
        }
    }

}
