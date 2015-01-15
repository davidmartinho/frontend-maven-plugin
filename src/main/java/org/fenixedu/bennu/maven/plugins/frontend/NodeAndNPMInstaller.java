package org.fenixedu.bennu.maven.plugins.frontend;

import org.fenixedu.bennu.maven.plugins.frontend.exception.InstallationException;

public interface NodeAndNPMInstaller {

    String DEFAULT_NODEJS_DOWNLOAD_ROOT = "http://nodejs.org/dist/";
    String DEFAULT_NPM_DOWNLOAD_ROOT = "http://registry.npmjs.org/npm/-/";

    void install(String nodeVersion, String npmVersion) throws InstallationException;

    void install(String nodeVersion, String npmVersion, String nodeDownloadRoot, String npmDownloadRoot)
            throws InstallationException;
}
