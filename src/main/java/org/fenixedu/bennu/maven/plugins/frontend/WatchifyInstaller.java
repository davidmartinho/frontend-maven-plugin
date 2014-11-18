package org.fenixedu.bennu.maven.plugins.frontend;

public interface WatchifyInstaller {

    static final String TASK_NAME = "npm install watchify";
    static final String TASK_LOCATION = "/node/npm/bin/npm-cli.js";

    void install() throws TaskRunnerException;
}
