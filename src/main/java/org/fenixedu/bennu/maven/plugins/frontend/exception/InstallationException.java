package org.fenixedu.bennu.maven.plugins.frontend.exception;


public final class InstallationException extends Exception {

    private static final long serialVersionUID = 9187038427222157210L;

    public InstallationException(String message) {
        super(message);
    }

    public InstallationException(String message, Throwable cause) {
        super(message, cause);
    }
}