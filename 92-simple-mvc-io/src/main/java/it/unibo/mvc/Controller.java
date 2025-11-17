package it.unibo.mvc;

import java.io.File;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String HOME = System.getProperty("user.home");
    private static final String SEPARATOR = System.getProperty("file.separator");

    private File currentFile = new File(HOME + SEPARATOR + "output.txt");

    public void setCurrentFile(final File newFile) {
        this.currentFile = newFile;
    }

    public File getCurrentFile() {
        return this.currentFile;
    }
}
