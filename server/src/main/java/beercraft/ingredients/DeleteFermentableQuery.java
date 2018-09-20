package beercraft.ingredients;

import beercraft.Query;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class DeleteFermentableQuery implements Query<Boolean> {
    protected AmazonDynamoDB databaseClient;
    protected String fermentableId;

    public DeleteFermentableQuery(AmazonDynamoDB databaseClient, String fermentableId) {
        this.databaseClient = databaseClient;
        this.fermentableId = fermentableId;
    }

    public Boolean execute() {
        Fermentable fermentable = new Fermentable();
        fermentable.setId(fermentableId);

        DynamoDBMapper mapper = new DynamoDBMapper(databaseClient);
        mapper.delete(fermentable);

        return true;
    }
}
