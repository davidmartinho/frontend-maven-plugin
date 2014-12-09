package org.fenixedu.bennu.maven.plugins.frontend;

public interface BowerInstaller {

    static final String TASK_NAME = "npm install bower";
    static final String TASK_LOCATION = "/node/npm/bin/npm-cli.js";

    void install() throws TaskRunnerException;
}
