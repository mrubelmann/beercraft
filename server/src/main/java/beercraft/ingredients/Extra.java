package beercraft.ingredients;

import beercraft.util.DatabaseItem;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.*;

@DynamoDBTable(tableName = "Extras")
public class Extra implements Ingredient, DatabaseItem {
    private String partitionKey;
    private String sortKey;
    private String name;
    private String notes;
    private IngredientUse defaultUse;
    private ExtraCategory category;
    private MeasurementType measurementType;

    @DynamoDBHashKey(attributeName = "PK")
    public String getPartitionKey() { return partitionKey; }
    public void setPartitionKey(String partitionKey) { this.partitionKey = partitionKey; }

    @DynamoDBRangeKey(attributeName = "SK")
    public String getSortKey() { return sortKey; }
    public void setSortKey(String sortKey) { this.sortKey = sortKey; }

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
