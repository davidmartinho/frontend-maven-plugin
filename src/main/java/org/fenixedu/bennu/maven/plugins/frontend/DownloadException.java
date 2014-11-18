package org.fenixedu.bennu.maven.plugins.frontend;

public final class DownloadException extends Exception {

    private static final long serialVersionUID = 1363891445346175257L;

    public DownloadException(String message) {
        super(message);
    }

    DownloadException(String message, Throwable cause) {
        super(message, cause);
    }
}