package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;

import com.google.common.collect.Lists;

public class DefaultBowerRunner extends NodeTaskExecutor implements BowerRunner {

    public DefaultBowerRunner(Platform platform, File workingDirectory) {
        super(TASK_NAME, TASK_LOCATION, workingDirectory, platform, Lists.newArrayList("install"));
    }

}
