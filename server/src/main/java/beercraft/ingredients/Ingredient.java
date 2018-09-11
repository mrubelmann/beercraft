package beercraft.ingredients;

public interface Ingredient {
    /**
     * @return The database record ID
     */
    String getId();

    /**
     * @param id The database record ID
     */
    void setId(String id);

    /**
     * @return The ingredient's name
     */
    String getName();

    /**
     * @param name The ingredient's name
     */
    void setName(String name);

    /**
     * @return Notes about the ingredient
     */
    String getNotes();

    /**
     * @param notes Notes about the ingredient
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
     * @return The default length of time to use the ingredient
     */
    double getDefaultTimeInMinutes();

    /**
     * @param time The default length of time to use the ingredient
     */
    void setDefaultTimeInMinutes(double time);
}
