package beercraft.ingredients;

import com.fasterxml.jackson.annotation.JsonValue;

public class Fermentable implements Ingredient {
    private String id;
    private String name;
    private String notes;
    private Measurement defaultAmount;
    private double defaultTimeInMinutes;
    private double color;

    @JsonValue
    public String getId() {
        return null;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonValue
    public String getName() {
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonValue
    public String getNotes() {
        return null;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @JsonValue
    public Measurement getDefaultAmount() {
        return defaultAmount;
    }

    public void setDefaultAmount(Measurement defaultAmount) {
        this.defaultAmount = defaultAmount;
    }

    @JsonValue
    public double getDefaultTimeInMinutes() {
        return defaultTimeInMinutes;
    }

    public void setDefaultTimeInMinutes(double defaultTimeInMinutes) {
        this.defaultTimeInMinutes = defaultTimeInMinutes;
    }

    @JsonValue
    public double getColor() {
        return color;
    }

    public void setColor(double color) {
        this.color = color;
    }
}
