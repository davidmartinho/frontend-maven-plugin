package org.fenixedu.bennu.maven.plugins.frontend.installer;

import java.io.File;

import org.fenixedu.bennu.maven.plugins.frontend.NPMModuleInstaller;
import org.fenixedu.bennu.maven.plugins.frontend.Platform;

public class DefaultHttpServerInstaller extends NPMModuleInstaller {

    public DefaultHttpServerInstaller(Platform platform, File workingDirectory) {
        super("http-server", workingDirectory, platform);
    }

}
