package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;
import java.util.Arrays;

import org.fenixedu.bennu.maven.plugins.frontend.exception.TaskRunnerException;

public class DefaultWatchifyRunner extends NodeTaskExecutor implements WatchifyRunner {

    public DefaultWatchifyRunner(Platform platform, File workingDirectory) {
        super(TASK_NAME, TASK_LOCATION, workingDirectory, platform, Arrays.asList("-v"));
    }

    @Override
    public void execute(String args, File sourceFile, File outputFile) throws TaskRunnerException {
    	outputFile.getParentFile().mkdirs();
        super.execute(String.format("-t debowerify  %s -o %s", sourceFile.getAbsolutePath(), outputFile.getAbsolutePath()));
    }
}
