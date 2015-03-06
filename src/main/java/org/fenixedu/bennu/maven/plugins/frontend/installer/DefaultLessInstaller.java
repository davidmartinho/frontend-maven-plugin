package org.fenixedu.bennu.maven.plugins.frontend.installer;

import java.io.File;

import org.fenixedu.bennu.maven.plugins.frontend.NPMModuleInstaller;
import org.fenixedu.bennu.maven.plugins.frontend.Platform;

public class DefaultLessInstaller extends NPMModuleInstaller {

    public DefaultLessInstaller(Platform platform, File workingDirectory) {
        super("less", workingDirectory, platform);
    }

}
