package beercraft.ingredients;

import beercraft.Query;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class AddExtraQuery implements Query<Extra> {
    protected AmazonDynamoDB databaseClient;
    protected Extra extra;

    public AddExtraQuery(AmazonDynamoDB databaseClient, Extra extra) {
        this.databaseClient = databaseClient;
        this.extra = extra;
    }

    public Extra execute() {
        DynamoDBMapper mapper = new DynamoDBMapper(databaseClient);
        mapper.save(extra);
        return extra;
    }
}
