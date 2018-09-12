package beercraft.ingredients;

import beercraft.Query;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class AddFermentableQuery implements Query<Fermentable> {
    protected AmazonDynamoDB databaseClient;
    protected Fermentable fermentable;

    public AddFermentableQuery(AmazonDynamoDB databaseClient, Fermentable fermentable) {
        this.databaseClient = databaseClient;
        this.fermentable = fermentable;
    }

    public Fermentable execute() {
        DynamoDBMapper mapper = new DynamoDBMapper(databaseClient);
        mapper.save(fermentable);
        return fermentable;
    }
}
