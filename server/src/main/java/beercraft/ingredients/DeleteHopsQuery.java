package beercraft.ingredients;

import beercraft.Query;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class DeleteHopsQuery implements Query<Boolean> {
    protected AmazonDynamoDB databaseClient;
    protected String hopsId;

    public DeleteHopsQuery(AmazonDynamoDB databaseClient, String hopsId) {
        this.databaseClient = databaseClient;
        this.hopsId = hopsId;
    }

    public Boolean execute() {
        Hops hops = new Hops();
        hops.setId(hopsId);

        DynamoDBMapper mapper = new DynamoDBMapper(databaseClient);
        mapper.delete(hops);

        return true;
    }
}
