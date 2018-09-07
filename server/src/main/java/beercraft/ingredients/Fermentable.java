package beercraft.ingredients;

public class Fermentable implements Ingredient {
    private String id;
    private String name;
    private String notes;
    private Measurement amount;
    private double time;

    public String getId() {
        return null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return null;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Measurement getDefaultAmount() {
        return null;
    }

    public void setDefaultAmount(Measurement amount) {
        this.amount = amount;
    }

    public double getDefaultTimeInMinutes() {
        return 0;
    }

    public void setDefaultTimeInMinutes(double time) {
        this.time = time;
    }
}
