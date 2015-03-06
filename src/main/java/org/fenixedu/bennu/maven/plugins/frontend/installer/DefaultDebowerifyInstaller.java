package org.fenixedu.bennu.maven.plugins.frontend.installer;

import java.io.File;

import org.fenixedu.bennu.maven.plugins.frontend.NPMModuleInstaller;
import org.fenixedu.bennu.maven.plugins.frontend.Platform;

public class DefaultDebowerifyInstaller extends NPMModuleInstaller {

    public DefaultDebowerifyInstaller(Platform platform, File workingDirectory) {
        super("debowerify", workingDirectory, platform);
    }

}
