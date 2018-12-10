package beercraft.ingredients;

import beercraft.util.DatabaseItem;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.*;

@DynamoDBTable(tableName = "Hops")
public class Hops implements Ingredient, DatabaseItem {
    private String partitionKey;
    private String sortKey;
    private String name;
    private String notes;
    private double defaultAmount;
    private double defaultTimeInMinutes;
    private double alpha;
    private HopsType type;
    private HopsForm form;
    private double beta;
    private double hsi;
    private String origin;
    private String substitutes;
    private double humulene;
    private double caryophyllene;
    private double cohumulone;
    private double myrcene;

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
    public void setDefaultTimeInMinutes(double defaultTimeInMinutes) {
        this.defaultTimeInMinutes = defaultTimeInMinutes;
    }

    @DynamoDBAttribute(attributeName = "Alpha")
    public double getAlpha() {
        return alpha;
    }
    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    @DynamoDBTyped(DynamoDBAttributeType.S)
    public HopsType getType() {
        return type;
    }
    public void setType(HopsType type) {
        this.type = type;
    }

    @DynamoDBTyped(DynamoDBAttributeType.S)
    public HopsForm getForm() {
        return form;
    }
    public void setForm(HopsForm form) {
        this.form = form;
    }

    @DynamoDBAttribute(attributeName = "Beta")
    public double getBeta() {
        return beta;
    }
    public void setBeta(double beta) {
        this.beta = beta;
    }

    @DynamoDBAttribute(attributeName = "Hsi")
    public double getHsi() {
        return hsi;
    }
    public void setHsi(double hsi) {
        this.hsi = hsi;
    }

    @DynamoDBAttribute(attributeName = "Origin")
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @DynamoDBAttribute(attributeName = "Substitutes")
    public String getSubstitutes() {
        return substitutes;
    }
    public void setSubstitutes(String substitutes) {
        this.substitutes = substitutes;
    }

    @DynamoDBAttribute(attributeName = "Humulene")
    public double getHumulene() {
        return humulene;
    }
    public void setHumulene(double humulene) {
        this.humulene = humulene;
    }

    @DynamoDBAttribute(attributeName = "Caryophyllene")
    public double getCaryophyllene() {
        return caryophyllene;
    }
    public void setCaryophyllene(double caryophyllene) {
        this.caryophyllene = caryophyllene;
    }

    @DynamoDBAttribute(attributeName = "Cohumulone")
    public double getCohumulone() {
        return cohumulone;
    }
    public void setCohumulone(double cohumulone) {
        this.cohumulone = cohumulone;
    }

    @DynamoDBAttribute(attributeName = "Myrcene")
    public double getMyrcene() {
        return myrcene;
    }
    public void setMyrcene(double myrcene) {
        this.myrcene = myrcene;
    }
}
