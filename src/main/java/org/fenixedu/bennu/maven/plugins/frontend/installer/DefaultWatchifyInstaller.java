package org.fenixedu.bennu.maven.plugins.frontend.installer;

import java.io.File;

import org.fenixedu.bennu.maven.plugins.frontend.NPMModuleInstaller;
import org.fenixedu.bennu.maven.plugins.frontend.Platform;

public class DefaultWatchifyInstaller extends NPMModuleInstaller {

    public DefaultWatchifyInstaller(Platform platform, File workingDirectory) {
        super("watchify", workingDirectory, platform);
    }

}
