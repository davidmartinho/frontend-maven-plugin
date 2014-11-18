package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;
import java.util.Arrays;

public class DefaultBrowserifyRunner extends NodeTaskExecutor implements BrowserifyRunner {

    public DefaultBrowserifyRunner(Platform platform, File workingDirectory) {
        super(TASK_NAME, TASK_LOCATION, workingDirectory, platform, Arrays.asList(""));
    }

    public void execute(String args, File sourceFile, File outputFile) throws TaskRunnerException {
        super.execute(String.format("%s -o %s", sourceFile.getAbsolutePath(), outputFile.getAbsolutePath()));
    }
}
