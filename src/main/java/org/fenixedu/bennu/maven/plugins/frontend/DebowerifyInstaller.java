package org.fenixedu.bennu.maven.plugins.frontend;

public interface DebowerifyInstaller {

    static final String TASK_NAME = "npm install debowerify";
    static final String TASK_LOCATION = "/node/npm/bin/npm-cli.js";

    void install() throws TaskRunnerException;
}
