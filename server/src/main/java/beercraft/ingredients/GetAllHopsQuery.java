package beercraft.ingredients;

import beercraft.Query;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

import java.util.List;

public class GetAllHopsQuery implements Query<List<Hops>> {
    protected AmazonDynamoDB databaseClient;

    public GetAllHopsQuery(AmazonDynamoDB databaseClient) {
        this.databaseClient = databaseClient;
    }

    public List<Hops> execute() {
        DynamoDBMapper mapper = new DynamoDBMapper(databaseClient);
        return mapper.scan(Hops.class, new DynamoDBScanExpression());
    }
}
