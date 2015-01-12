package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NPMConfigurer extends NodeTaskExecutor implements NPMRunner {
    static final String TASK_NAME = "npm";
    static final String TASK_LOCATION = "/node/npm/bin/npm-cli.js";

    public NPMConfigurer(Platform platform, File workingDirectory, String pythonPath) {
        super(TASK_NAME, TASK_LOCATION, workingDirectory, platform, buildArguments(pythonPath));
    }

    private static List<String> buildArguments(String pythonPath) {
        List<String> arguments = new ArrayList<String>();
        addConfiguration(arguments, "python", pythonPath);
        return arguments;
    }

    private static void addConfiguration(List<String> arguments, String key, String value) {
        arguments.add("config");
        arguments.add("set");
        arguments.add(key);
        arguments.add(value);
    }

}
