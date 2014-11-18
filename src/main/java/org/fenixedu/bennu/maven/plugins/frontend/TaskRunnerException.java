package org.fenixedu.bennu.maven.plugins.frontend;

public class TaskRunnerException extends Exception {

    private static final long serialVersionUID = 1518687607668276616L;

    public TaskRunnerException(String message) {
        super(message);
    }

    public TaskRunnerException(String message, Throwable cause) {
        super(message, cause);
    }
}