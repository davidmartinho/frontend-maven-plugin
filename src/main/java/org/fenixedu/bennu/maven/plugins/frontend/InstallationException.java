package org.fenixedu.bennu.maven.plugins.frontend;

public final class InstallationException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 9187038427222157210L;

    InstallationException(String message) {
        super(message);
    }

    InstallationException(String message, Throwable cause) {
        super(message, cause);
    }
}