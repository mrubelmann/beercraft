package beercraft.ingredients;

import beercraft.util.DatabaseItem;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.*;

@DynamoDBTable(tableName = "Extras")
public class Extra implements Ingredient, DatabaseItem {
    private String pk;
    private String sk;
    private String name;
    private String notes;
    private IngredientUse defaultUse;
    private ExtraCategory category;
    private MeasurementType measurementType;

    @DynamoDBHashKey(attributeName = "PK")
    public String getPK() { return pk; }
    public void setPK(String partitionKey) { this.pk = partitionKey; }

    @DynamoDBRangeKey(attributeName = "SK")
    public String getSK() { return sk; }
    public void setSK(String sortKey) { this.sk = sortKey; }

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

    @DynamoDBTyped(DynamoDBAttributeType.S)
    public IngredientUse getDefaultUse() { return defaultUse; }
    public void setDefaultUse(IngredientUse defaultUse) { this.defaultUse = defaultUse; }

    @DynamoDBTyped(DynamoDBAttributeType.S)
    public ExtraCategory getCategory() { return category; }
    public void setCategory(ExtraCategory category) { this.category = category; }

    @DynamoDBTyped(DynamoDBAttributeType.S)
    public MeasurementType getMeasurementType() { return measurementType; }
    public void setMeasurementType(MeasurementType measurementType) { this.measurementType = measurementType; }
}
