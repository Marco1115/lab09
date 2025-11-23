package it.unibo.mvc;

import java.util.List;

/**
 * Interface of IO controller.
 */
public interface Controller {

    /**
     * Sets the next string to be printed. Null values are non accepted.
     * 
     * @param nextString the string to be set as the next string
     * @throws NullPointerException if the argument is null
     */
    void setNextString(String nextString);

    /**
     * Gets the next string to be printed.
     * 
     * @return the next string to be printed
     */
    String getNextString();

    /**
     * Gets the history of the printed strings.
     * 
     * @return a list containing all the string that have been printed
     */
    List<String> getHistory();

    /**
     * Prints the current string.
     * 
     * @throws IllegalStateException if no string is set
     */
    void printString();
}
