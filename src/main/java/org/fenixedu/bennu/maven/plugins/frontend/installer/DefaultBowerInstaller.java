package org.fenixedu.bennu.maven.plugins.frontend.installer;

import java.io.File;

import org.fenixedu.bennu.maven.plugins.frontend.NPMModuleInstaller;
import org.fenixedu.bennu.maven.plugins.frontend.Platform;

public class DefaultBowerInstaller extends NPMModuleInstaller {

    public DefaultBowerInstaller(Platform platform, File workingDirectory) {
        super("bower", workingDirectory, platform);
    }

}
