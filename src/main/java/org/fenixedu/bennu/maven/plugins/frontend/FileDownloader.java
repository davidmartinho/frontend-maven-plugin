package org.fenixedu.bennu.maven.plugins.frontend;

public interface FileDownloader {
    void download(String downloadUrl, String destination) throws DownloadException;
}
