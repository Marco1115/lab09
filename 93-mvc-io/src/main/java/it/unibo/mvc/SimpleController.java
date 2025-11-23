package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Implementation of the controller interface.
 */
public final class SimpleController implements Controller {

    private final List<String> history = new ArrayList<>();
    private String nextString;

    @Override
    public void setNextString(final String nextString) {
        Objects.requireNonNull(nextString);
        this.nextString = nextString;
    }

    @Override
    public String getNextString() {
        return this.nextString;
    }

    @Override
    public List<String> getHistory() {
        return this.history;
    }

    @Override
    public void printString() {
        if (this.nextString == null) {
            throw new IllegalStateException("No string is set");
        }
        System.out.println(this.nextString); //NOPMD: required by the exercise
        history.addLast(this.nextString);
    }

}
