package org.fenixedu.bennu.maven.plugins.frontend;

import org.fenixedu.bennu.maven.plugins.frontend.exception.TaskRunnerException;

public interface BowerLink {

    static String TASK_NAME = "bower";
    static final String TASK_LOCATION = "/node_modules/bower/bin/bower";

    public void execute(String args) throws TaskRunnerException;
}
