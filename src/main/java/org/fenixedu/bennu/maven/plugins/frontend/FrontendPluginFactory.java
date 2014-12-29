package org.fenixedu.bennu.maven.plugins.frontend;

import java.io.File;

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

    public BrowserifyInstaller getBrowserifyInstaller() {
        return new DefaultBrowserifyInstaller(defaultPlatform, workingDirectory);
    }

    public BrowserifyRunner getBrowserifyRunner() {
        return new DefaultBrowserifyRunner(defaultPlatform, workingDirectory);
    }

    public WatchifyRunner getWatchifyRunner() {
        return new DefaultWatchifyRunner(defaultPlatform, workingDirectory);
    }

    public WatchifyInstaller getWatchifyInstaller() {
        return new DefaultWatchifyInstaller(defaultPlatform, workingDirectory);
    }

    public BowerInstaller getBowerInstaller() {
        return new DefaultBowerInstaller(defaultPlatform, workingDirectory);
    }

    public BowerRunner getBowerRunner() {
        return new DefaultBowerRunner(defaultPlatform, workingDirectory);
    }

    public UglifyInstaller getUglifyInstaller() {
        return new DefaultUglifyInstaller(defaultPlatform, workingDirectory);
    }

    public UglifyRunner getUglifyRunner() {
        return new DefaultUglifyRunner(defaultPlatform, workingDirectory);
    }
}