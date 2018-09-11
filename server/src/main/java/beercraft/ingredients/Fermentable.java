package beercraft.ingredients;

public class Fermentable implements Ingredient {
    private String id;
    private String name;
    private String notes;
    private double defaultAmount;
    private double defaultTimeInMinutes;
    private double color;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public double getDefaultAmount() {
        return defaultAmount;
    }

    public void setDefaultAmount(double defaultAmount) {
        this.defaultAmount = defaultAmount;
    }

    public double getDefaultTimeInMinutes() {
        return defaultTimeInMinutes;
    }

    public void setDefaultTimeInMinutes(double defaultTimeInMinutes) {
        this.defaultTimeInMinutes = defaultTimeInMinutes;
    }

    public double getColor() {
        return color;
    }

    public void setColor(double color) {
        this.color = color;
    }
}
