package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;

public interface UglifyRunner {

    static final String TASK_NAME = "uglify-js";
    static final String TASK_LOCATION = "/node_modules/uglify-js/bin/uglifyjs";

    public void execute(String args, File sourceFile) throws TaskRunnerException;

}
