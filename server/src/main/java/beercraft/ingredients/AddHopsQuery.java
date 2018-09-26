package beercraft.ingredients;

import beercraft.Query;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class AddHopsQuery implements Query<Hops> {
    protected AmazonDynamoDB databaseClient;
    protected Hops hops;

    public AddHopsQuery(AmazonDynamoDB databaseClient, Hops hops) {
        this.databaseClient = databaseClient;
        this.hops = hops;
    }

    public Hops execute() {
        DynamoDBMapper mapper = new DynamoDBMapper(databaseClient);
        mapper.save(hops);
        return hops;
    }
}
