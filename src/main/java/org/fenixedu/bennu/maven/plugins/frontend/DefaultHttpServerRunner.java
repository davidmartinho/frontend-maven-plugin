package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;
import java.util.ArrayList;

import org.fenixedu.bennu.maven.plugins.frontend.exception.TaskRunnerException;

public class DefaultHttpServerRunner extends NodeTaskExecutor implements HttpServerRunner {

    public DefaultHttpServerRunner(Platform defaultplatform, File workingDirectory) {
        super(TASK_NAME, TASK_LOCATION, workingDirectory, defaultplatform, new ArrayList<>());
    }

    @Override
    public void execute(String path, String port) throws TaskRunnerException {
        super.execute(String.format("%s -p%s -c-1", path, port));
    }
}
