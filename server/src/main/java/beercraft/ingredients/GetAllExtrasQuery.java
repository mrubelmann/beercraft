package beercraft.ingredients;

import beercraft.Query;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

import java.util.List;

public class GetAllExtrasQuery implements Query<List<Extra>> {
    protected AmazonDynamoDB databaseClient;

    public GetAllExtrasQuery(AmazonDynamoDB databaseClient) {
        this.databaseClient = databaseClient;
    }

    public List<Extra> execute() {
        DynamoDBMapper mapper = new DynamoDBMapper(databaseClient);
        return mapper.scan(Extra.class, new DynamoDBScanExpression());
    }
}
