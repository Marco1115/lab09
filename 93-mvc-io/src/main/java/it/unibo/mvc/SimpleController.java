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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNextString'");
    }

    @Override
    public List<String> getHistory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHistory'");
    }

    @Override
    public void printString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printString'");
    }

}
