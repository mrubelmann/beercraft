package beercraft.ingredients;

import beercraft.util.DatabaseItem;
import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "UberTable")
public class Fermentable implements Ingredient, DatabaseItem {
    private String pk;
    private String sk;
    private String name;
    private String notes;
    private double color;
    private FermentableType type;
    private double yield;
    private boolean lateBoilAddition;
    private String origin;
    private String supplier;
    private double coarseFineDiff;
    private double moisture;
    private double diastaticPower;
    private double protein;
    private double maxInBatch;
    private boolean recommendMash;
    private boolean mashed;

    @DynamoDBHashKey
    public String getPK() { return pk; }
    public void setPK(String pk) { this.pk = pk; }

    @DynamoDBRangeKey
    public String getSK() { return sk; }
    public void setSK(String sk) { this.sk = sk; }

    @DynamoDBAttribute
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @DynamoDBAttribute
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    @DynamoDBAttribute
    public double getColor() { return color; }
    public void setColor(double color) { this.color = color; }

    @DynamoDBAttribute
    public FermentableType getType() { return type; }
    public void setType(FermentableType type) { this.type = type; }

    @DynamoDBAttribute
    public double getYield() { return yield; }
    public void setYield(double yield) { this.yield = yield; }

    @DynamoDBAttribute
    public boolean getLateBoilAddition() { return lateBoilAddition; }
    public void setLateBoilAddition(boolean lateBoilAddition) { this.lateBoilAddition = lateBoilAddition; }

    @DynamoDBAttribute
    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    @DynamoDBAttribute
    public String getSupplier() { return supplier; }
    public void setSupplier(String supplier) { this.supplier = supplier; }

    @DynamoDBAttribute
    public double getCoarseFineDiff() { return coarseFineDiff; }
    public void setCoarseFineDiff(double coarseFineDiff) { this.coarseFineDiff = coarseFineDiff; }

    @DynamoDBAttribute
    public double getMoisture() { return moisture; }
    public void setMoisture(double moisture) { this.moisture = moisture; }

    @DynamoDBAttribute
    public double getDiastaticPower() { return diastaticPower; }
    public void setDiastaticPower(double diastaticPower) { this.diastaticPower = diastaticPower; }

    @DynamoDBAttribute
    public double getProtein() { return protein; }
    public void setProtein(double protein) { this.protein = protein; }

    @DynamoDBAttribute
    public double getMaxInBatch() { return maxInBatch; }
    public void setMaxInBatch(double maxInBatch) { this.maxInBatch = maxInBatch; }

    @DynamoDBAttribute
    public boolean getRecommendMash() { return recommendMash; }
    public void setRecommendMash(boolean recommendMash) { this.recommendMash = recommendMash; }

    @DynamoDBAttribute
    public boolean getMashed() { return mashed; }
    public void setMashed(boolean mashed) { this.mashed = mashed; }
}
