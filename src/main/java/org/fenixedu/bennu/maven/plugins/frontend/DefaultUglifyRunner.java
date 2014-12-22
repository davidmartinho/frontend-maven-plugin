package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;
import java.util.Arrays;

public class DefaultUglifyRunner extends NodeTaskExecutor implements UglifyRunner {

    public DefaultUglifyRunner(Platform platform, File workingDirectory) {
        super(TASK_NAME, TASK_LOCATION, workingDirectory, platform, Arrays.asList(""));
    }

    @Override
    public void execute(String args, File sourceFile) throws TaskRunnerException {
        super.execute(String.format("%s -o %s", sourceFile.getAbsolutePath(), sourceFile.getAbsolutePath()));
    }
}
