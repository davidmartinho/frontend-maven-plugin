package org.fenixedu.bennu.maven.plugins.frontend;

import static org.fenixedu.bennu.maven.plugins.frontend.Utils.implode;
import static org.fenixedu.bennu.maven.plugins.frontend.Utils.normalize;
import static org.fenixedu.bennu.maven.plugins.frontend.Utils.prepend;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.fenixedu.bennu.maven.plugins.frontend.exception.TaskRunnerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class NodeTaskExecutor {

    private final Logger logger;
    private final String taskName;
    private final String taskLocation;
    private final Platform platform;
    private final File workingDirectory;
    private final List<String> arguments;

    public NodeTaskExecutor(String taskName, String taskLocation, File workingDirectory, Platform platform,
            List<String> additionalArguments) {
        this.logger = LoggerFactory.getLogger(getClass());
        this.taskName = taskName;
        this.taskLocation = taskLocation;
        this.platform = platform;
        this.workingDirectory = workingDirectory;
        this.arguments = additionalArguments;
    }

    public File getWorkingDirectory() {
        return workingDirectory;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void execute(String args) throws TaskRunnerException {
        final String absoluteTaskLocation = workingDirectory + normalize(taskLocation);
        final List<String> execArguments = getArguments(args);
        logger.info("Running " + taskToString(taskName, execArguments) + " in " + workingDirectory);

        try {
            final int result =
                    new NodeExecutor(workingDirectory, prepend(absoluteTaskLocation, execArguments), platform)
                            .executeAndRedirectOutput(logger);
            if (result != 0) {
                throw new TaskRunnerException(taskToString(taskName, execArguments) + " failed. (error code " + result + ")");
            }
        } catch (ProcessExecutionException e) {
            throw new TaskRunnerException(taskToString(taskName, execArguments) + " failed.", e);
        }
    }

    public void execute() throws TaskRunnerException {
        execute("");
    }

    private List<String> getArguments(String args) {
        List<String> execArguments = new ArrayList<String>();

        for (String argument : this.arguments) {
            if (!execArguments.contains(argument) && !argument.isEmpty()) {
                execArguments.add(argument);
            }
        }

        if (args != null && !args.equals("null")) {
            execArguments.addAll(Arrays.asList(args.split("\\s+")));
        }

        return execArguments;
    }

    private static String taskToString(String taskName, List<String> commands) {
        return "'" + taskName + " " + implode(" ", commands) + "'";
    }
}
