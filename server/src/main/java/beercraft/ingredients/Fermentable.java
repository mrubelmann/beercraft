package beercraft.ingredients;

import beercraft.util.DatabaseItem;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Fermentables")
public class Fermentable implements Ingredient, DatabaseItem {
    private String id;
    private String name;
    private String notes;
    private double defaultAmount;
    private double defaultTimeInMinutes;
    private double color;

    @DynamoDBHashKey(attributeName = "Id")
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute(attributeName = "Name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute(attributeName = "Notes")
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

    @DynamoDBAttribute(attributeName = "DefaultAmount")
    public double getDefaultAmount() {
        return defaultAmount;
    }
    public void setDefaultAmount(double defaultAmount) {
        this.defaultAmount = defaultAmount;
    }

    @DynamoDBAttribute(attributeName = "DefaultTimeInMinutes")
    public double getDefaultTimeInMinutes() {
        return defaultTimeInMinutes;
    }
    public void setDefaultTimeInMinutes(double defaultTimeInMinutes) { this.defaultTimeInMinutes = defaultTimeInMinutes; }

    @DynamoDBAttribute(attributeName = "Color")
    public double getColor() {
        return color;
    }
    public void setColor(double color) {
        this.color = color;
    }
}
