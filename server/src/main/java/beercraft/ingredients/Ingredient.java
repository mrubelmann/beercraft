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

    /**
     * @return The default amount to use in a recipe
     */
    double getDefaultAmount();

    /**
     * @param amount The default amount to use in a recipe
     */
    void setDefaultAmount(double amount);

    /**
     * @return The default length of time to use the itemType
     */
    double getDefaultTimeInMinutes();

    /**
     * @param time The default length of time to use the itemType
     */
    void setDefaultTimeInMinutes(double time);
}
