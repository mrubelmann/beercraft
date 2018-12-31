package beercraft.recipes;

import beercraft.util.DatabaseItem;
import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.List;

@DynamoDBTable(tableName = "Recipes")
public class Recipe implements DatabaseItem {
    private String pk;
    private String sk;
    private String name;
    private String description;
    private List<RecipeIngredient> fermentables;
    private List<RecipeIngredient> hops;
    private List<RecipeIngredient> extras;
    private List<RecipeIngredient> yeast;
    private double volume;
    private double boilTime;
    private Style style;

    @DynamoDBHashKey(attributeName = "PK")
    public String getPK() { return pk; }
    public void setPK(String partitionKey) { this.pk = partitionKey; }

    @DynamoDBRangeKey(attributeName = "SK")
    public String getSK() { return sk; }
    public void setSK(String sortKey) { this.sk = sortKey; }

    @DynamoDBAttribute
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @DynamoDBAttribute
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @DynamoDBAttribute
    public List<RecipeIngredient> getFermentables() { return fermentables; }
    public void setFermentables(List<RecipeIngredient> fermentables) { this.fermentables = fermentables; }

    @DynamoDBAttribute
    public List<RecipeIngredient> getHops() { return hops; }
    public void setHops(List<RecipeIngredient> hops) { this.hops = hops; }

    @DynamoDBAttribute
    public List<RecipeIngredient> getExtras() { return extras; }
    public void setExtras(List<RecipeIngredient> extras) { this.extras = extras; }

    @DynamoDBAttribute
    public List<RecipeIngredient> getYeast() { return yeast; }
    public void setYeast(List<RecipeIngredient> yeast) { this.yeast = yeast; }

    @DynamoDBAttribute
    public double getVolume() { return volume; }
    public void setVolume(double volume) { this.volume = volume; }

    @DynamoDBAttribute
    public double getBoilTime() { return boilTime; }
    public void setBoilTime(double boilTime) { this.boilTime = boilTime; }

    @DynamoDBAttribute
    public Style getStyle() { return style; }
    public void setStyle(Style style) { this.style = style; }
}
