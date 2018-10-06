package beercraft.recipes;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class RecipeIngredient {
    private String id;
    private double amount;

    @DynamoDBAttribute
    public String getId() { return id; }
    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute
    public double getAmount() { return amount; }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
