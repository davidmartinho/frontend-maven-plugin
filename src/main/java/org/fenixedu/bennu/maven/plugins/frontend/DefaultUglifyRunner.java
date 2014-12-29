package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;
import java.util.ArrayList;

public class DefaultUglifyRunner extends NodeTaskExecutor implements UglifyRunner {

    public DefaultUglifyRunner(Platform platform, File workingDirectory) {
        super(TASK_NAME, TASK_LOCATION, workingDirectory, platform, new ArrayList<String>());
    }

    @Override
    public void execute(String args, File sourceFile) throws TaskRunnerException {
        super.execute(String.format("%s -o %s -c -m", sourceFile.getAbsolutePath(), sourceFile.getAbsolutePath()));
    }
}
