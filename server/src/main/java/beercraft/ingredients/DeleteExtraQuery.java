package beercraft.ingredients;

import beercraft.Query;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class DeleteExtraQuery implements Query<Boolean> {
    protected AmazonDynamoDB databaseClient;
    protected String extraId;

    public DeleteExtraQuery(AmazonDynamoDB databaseClient, String extraId) {
        this.databaseClient = databaseClient;
        this.extraId = extraId;
    }

    public Boolean execute() {
        Extra extra = new Extra();
        extra.setId(extraId);

        DynamoDBMapper mapper = new DynamoDBMapper(databaseClient);
        mapper.delete(extra);

        return true;
    }
}
