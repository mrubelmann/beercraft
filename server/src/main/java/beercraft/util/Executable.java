package beercraft.util;

/**
 * Defines something that can be executed without any additional parameters.
 * @param <T> Output type
 */
public interface Executable<T> {
    /**
     * Runs the thing.
     * @return The result of running the thing
     */
    T execute();
}
