package org.fenixedu.bennu.maven.plugins.frontend;

import org.fenixedu.bennu.maven.plugins.frontend.exception.TaskRunnerException;

public interface WatchifyInstaller {

    static final String TASK_NAME = "npm install watchify";
    static final String TASK_LOCATION = "/node/npm/bin/npm-cli.js";

    void install() throws TaskRunnerException;
}
