package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String HOME = System.getProperty("user.home");
    private static final String SEPARATOR = System.getProperty("file.separator");

    private File currentFile = new File(HOME + SEPARATOR + "output.txt");

    /**
     * Sets a new current file.
     * 
     * @param newFile the file to be set as current file
     */
    public void setCurrentFile(final File newFile) {
        this.currentFile = newFile;
    }

    /**
     * Gets the current destination file.
     * 
     * @return the current file.
     */
    public File getCurrentFile() {
        return this.currentFile;
    }

    /**
     * Gets the path of the current destination file.
     * 
     * @return the path of the current file
     */
    public String getCurrentFilePath() {
        return this.currentFile.getAbsolutePath();
    }

    /**
     * Writes a text into the current file.
     * 
     * @param content the string to be written
     * @throws IOException if the write operation fails
     */
    public void writeString(final String content) throws IOException {
        try (PrintStream ps = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
            ps.print(content);
        }
    }
}
