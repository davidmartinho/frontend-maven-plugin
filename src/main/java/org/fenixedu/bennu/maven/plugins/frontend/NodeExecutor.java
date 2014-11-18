package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;

final class NodeExecutor {
    private final ProcessExecutor executor;

    public NodeExecutor(File workingDirectory, List<String> arguments, Platform platform) {
        final String node = workingDirectory + Utils.normalize("/node/node");
        this.executor = new ProcessExecutor(workingDirectory, Utils.prepend(node, arguments), platform);
    }

    public String executeAndGetResult() throws ProcessExecutionException {
        return executor.executeAndGetResult();
    }

    public int executeAndRedirectOutput(final Logger logger) throws ProcessExecutionException {
        return executor.executeAndRedirectOutput(logger);
    }
}