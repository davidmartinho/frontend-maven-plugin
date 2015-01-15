package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;
import java.util.Arrays;

import org.fenixedu.bennu.maven.plugins.frontend.exception.TaskRunnerException;

public class DefaultBrowserifyRunner extends NodeTaskExecutor implements BrowserifyRunner {

    public DefaultBrowserifyRunner(Platform platform, File workingDirectory) {
        super(TASK_NAME, TASK_LOCATION, workingDirectory, platform, Arrays.asList(""));
    }

    @Override
    public void execute(String args, File sourceFile, File outputFile) throws TaskRunnerException {
        super.execute(String.format("%s -t debowerify -o %s", sourceFile.getAbsolutePath(), outputFile.getAbsolutePath()));
    }
}
