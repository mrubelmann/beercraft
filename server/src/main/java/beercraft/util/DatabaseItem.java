package beercraft.util;

/**
 * An interface representing something that has a string based ID.
 */
public interface DatabaseItem {
    /**
     * @return The ID
     */
    String getId();

    /**
     * @param id The ID
     */
    void setId(String id);
}
