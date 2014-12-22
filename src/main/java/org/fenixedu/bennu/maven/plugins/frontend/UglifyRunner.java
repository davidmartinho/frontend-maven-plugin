package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;

public interface UglifyRunner {

    static final String TASK_NAME = "uglify";
    static final String TASK_LOCATION = "/node_modules/uglify/bin/cmd.js";

    public void execute(String args, File sourceFile) throws TaskRunnerException;

}
