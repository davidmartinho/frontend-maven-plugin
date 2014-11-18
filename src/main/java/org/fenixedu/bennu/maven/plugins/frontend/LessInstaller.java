package org.fenixedu.bennu.maven.plugins.frontend;

public interface LessInstaller {

    static final String TASK_NAME = "npm install less";
    static final String TASK_LOCATION = "/node/npm/bin/npm-cli.js";

    void install() throws TaskRunnerException;

}
