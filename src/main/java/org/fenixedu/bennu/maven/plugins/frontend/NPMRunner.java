package org.fenixedu.bennu.maven.plugins.frontend;

import org.fenixedu.bennu.maven.plugins.frontend.exception.TaskRunnerException;

public interface NPMRunner {
    public void execute(String args) throws TaskRunnerException;
}
