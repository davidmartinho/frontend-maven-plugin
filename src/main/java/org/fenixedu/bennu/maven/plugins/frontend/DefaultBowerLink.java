package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;
import java.util.ArrayList;

import org.fenixedu.bennu.maven.plugins.frontend.exception.TaskRunnerException;

public class DefaultBowerLink extends NodeTaskExecutor implements BowerLink {

    public DefaultBowerLink(Platform platform, File workingDirectory) {
        super(TASK_NAME, TASK_LOCATION, workingDirectory, platform, new ArrayList<>());
    }

    @Override
    public final void execute(String packageName) throws TaskRunnerException {
        super.execute(String.format("link %s", packageName));
    }
}
