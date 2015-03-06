package org.fenixedu.bennu.maven.plugins.frontend.installer;

import java.io.File;

import org.fenixedu.bennu.maven.plugins.frontend.NPMModuleInstaller;
import org.fenixedu.bennu.maven.plugins.frontend.Platform;

public class DefaultUglifyInstaller extends NPMModuleInstaller {

    public DefaultUglifyInstaller(Platform platform, File workingDirectory) {
        super("uglify-js", workingDirectory, platform);
    }

}
