package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DefaultNPMRunner extends NodeTaskExecutor implements NPMRunner {
    static final String TASK_NAME = "npm";
    static final String TASK_LOCATION = "/node/npm/bin/npm-cli.js";

    public DefaultNPMRunner(Platform platform, File workingDirectory, ProxyConfig proxy) {
        super(TASK_NAME, TASK_LOCATION, workingDirectory, platform, buildArguments(proxy));
    }

    private static List<String> buildArguments(ProxyConfig proxy) {
        List<String> arguments = new ArrayList<String>();
        arguments.add("install");
        arguments.add("--color=false");
        if (proxy != null) {
            if (proxy.isSecure()) {
                arguments.add("--https-proxy=" + proxy.getUri().toString());
            } else {
                arguments.add("--proxy=" + proxy.getUri().toString());
            }
        }
        return arguments;
    }
}
