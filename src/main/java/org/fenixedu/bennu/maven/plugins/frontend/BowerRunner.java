package org.fenixedu.bennu.maven.plugins.frontend;

public interface BowerRunner {

    static String TASK_NAME = "bower";
    static final String TASK_LOCATION = "/node_modules/bower/bin/bower";

    public void execute(String args) throws TaskRunnerException;
}
