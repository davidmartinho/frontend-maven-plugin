package org.fenixedu.bennu.maven.plugins.frontend.installer;

import java.io.File;

import org.fenixedu.bennu.maven.plugins.frontend.NPMModuleInstaller;
import org.fenixedu.bennu.maven.plugins.frontend.Platform;

public class DefaultBrowserifyInstaller extends NPMModuleInstaller {

    private static final String MODULE_NAME = "browserify";

    public DefaultBrowserifyInstaller(Platform platform, File workingDirectory) {
        super(MODULE_NAME, workingDirectory, platform);
    }

}
