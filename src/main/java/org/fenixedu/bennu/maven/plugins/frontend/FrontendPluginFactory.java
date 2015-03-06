package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;

import org.fenixedu.bennu.maven.plugins.frontend.installer.DefaultBowerInstaller;
import org.fenixedu.bennu.maven.plugins.frontend.installer.DefaultBrowserifyInstaller;
import org.fenixedu.bennu.maven.plugins.frontend.installer.DefaultDebowerifyInstaller;
import org.fenixedu.bennu.maven.plugins.frontend.installer.DefaultHttpServerInstaller;
import org.fenixedu.bennu.maven.plugins.frontend.installer.DefaultUglifyInstaller;
import org.fenixedu.bennu.maven.plugins.frontend.installer.DefaultWatchifyInstaller;

public final class FrontendPluginFactory {
    private static final Platform defaultPlatform = Platform.guess();
    private final File workingDirectory;
    private final ProxyConfig proxy;

    public FrontendPluginFactory(File workingDirectory) {
        this(workingDirectory, null);
    }

    public FrontendPluginFactory(File workingDirectory, ProxyConfig proxy) {
        this.workingDirectory = workingDirectory;
        this.proxy = proxy;
    }

    public NPMRunner getNPMRunner() {
        return new DefaultNPMRunner(defaultPlatform, workingDirectory, proxy);
    }

    public NodeAndNPMInstaller getNodeAndNPMInstaller() {
        return new DefaultNodeAndNPMInstaller(workingDirectory, defaultPlatform, new DefaultArchiveExtractor(),
                new DefaultFileDownloader(proxy));
    }

    public NPMModuleInstaller getBrowserifyInstaller() {
        return new DefaultBrowserifyInstaller(defaultPlatform, workingDirectory);
    }

    public NPMConfigurer getNPMConfigurer(String pythonPath) {
        return new NPMConfigurer(defaultPlatform, workingDirectory, pythonPath);
    }

    public BrowserifyRunner getBrowserifyRunner() {
        return new DefaultBrowserifyRunner(defaultPlatform, workingDirectory);
    }

    public WatchifyRunner getWatchifyRunner() {
        return new DefaultWatchifyRunner(defaultPlatform, workingDirectory);
    }

    public NPMModuleInstaller getWatchifyInstaller() {
        return new DefaultWatchifyInstaller(defaultPlatform, workingDirectory);
    }

    public NPMModuleInstaller getBowerInstaller() {
        return new DefaultBowerInstaller(defaultPlatform, workingDirectory);
    }

    public BowerRunner getBowerRunner() {
        return new DefaultBowerRunner(defaultPlatform, workingDirectory);
    }

    public NPMModuleInstaller getUglifyInstaller() {
        return new DefaultUglifyInstaller(defaultPlatform, workingDirectory);
    }

    public UglifyRunner getUglifyRunner() {
        return new DefaultUglifyRunner(defaultPlatform, workingDirectory);
    }

    public NPMModuleInstaller getDebowerifyInstaller() {
        return new DefaultDebowerifyInstaller(defaultPlatform, workingDirectory);
    }

    public BowerLink getBowerLink() {
        return new DefaultBowerLink(defaultPlatform, workingDirectory);
    }

    public NPMModuleInstaller getHttpServerInstaller() {
        return new DefaultHttpServerInstaller(defaultPlatform, workingDirectory);
    }

    public HttpServerRunner getHttpServerRunner() {
        return new DefaultHttpServerRunner(defaultPlatform, workingDirectory);
    }
}
