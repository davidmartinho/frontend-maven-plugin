package org.fenixedu.bennu.maven.plugins.frontend;

import org.fenixedu.bennu.maven.plugins.frontend.exception.TaskRunnerException;

public interface HttpServerRunner {

    static String TASK_NAME = "http-server";
    static final String TASK_LOCATION = "/node_modules/http-server/bin/http-server";

    public void execute(String path, String port) throws TaskRunnerException;

}
