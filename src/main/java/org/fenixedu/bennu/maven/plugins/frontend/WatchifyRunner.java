package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;

public interface WatchifyRunner {

    static String TASK_NAME = "watchify";
    static String TASK_LOCATION = "/node_modules/watchify/bin/cmd.js";

    public void execute(String args, File sourceFile, File outputFile) throws TaskRunnerException;

}
