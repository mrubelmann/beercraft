package beercraft.ingredients;

public interface Ingredient {
    /**
     * @return The itemType's name
     */
    String getName();

    /**
     * @param name The itemType's name
     */
    void setName(String name);

    /**
     * @return Notes about the itemType
     */
    String getNotes();

    /**
     * @param notes Notes about the itemType
     */
    void setNotes(String notes);
}
