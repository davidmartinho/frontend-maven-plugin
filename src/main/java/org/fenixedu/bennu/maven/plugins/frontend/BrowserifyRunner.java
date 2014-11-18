package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;

public interface BrowserifyRunner {

    static final String TASK_NAME = "browserify";
    static final String TASK_LOCATION = "/node_modules/browserify/bin/cmd.js";

    public void execute(String args, File sourceFile, File outputFile) throws TaskRunnerException;

}
