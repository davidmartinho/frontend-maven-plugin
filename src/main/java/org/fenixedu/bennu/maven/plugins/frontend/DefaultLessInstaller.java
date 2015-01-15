package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;
import java.util.Arrays;

import org.fenixedu.bennu.maven.plugins.frontend.exception.TaskRunnerException;

public class DefaultLessInstaller extends NodeTaskExecutor implements LessInstaller {

    public DefaultLessInstaller(Platform platform, File workingDirectory) {
        super(TASK_NAME, TASK_LOCATION, workingDirectory, platform, Arrays.asList(""));
    }

    public void install() throws TaskRunnerException {
        super.execute("install less");
    }
}
