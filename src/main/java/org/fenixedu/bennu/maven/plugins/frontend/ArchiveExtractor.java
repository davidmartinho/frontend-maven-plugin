package org.fenixedu.bennu.maven.plugins.frontend;

public interface ArchiveExtractor {
    public void extract(String archive, String destinationDirectory) throws ArchiveExtractionException;
}
