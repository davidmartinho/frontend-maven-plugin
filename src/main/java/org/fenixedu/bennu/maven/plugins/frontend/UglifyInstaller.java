package org.fenixedu.bennu.maven.plugins.frontend;

public interface UglifyInstaller {

    static final String TASK_NAME = "npm install uglify";
    static final String TASK_LOCATION = "/node/npm/bin/npm-cli.js";

    void install() throws TaskRunnerException;

}
