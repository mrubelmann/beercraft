package beercraft.util;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

import java.util.List;

public class GetAllQuery<T> implements Query<List<T>> {
    protected AmazonDynamoDB databaseClient;
    private Class<T> itemClass;

    public GetAllQuery(AmazonDynamoDB databaseClient, Class<T> itemClass) {
        this.databaseClient = databaseClient;
        this.itemClass = itemClass;
    }

    public List<T> execute() {
        DynamoDBMapper mapper = new DynamoDBMapper(databaseClient);
        return mapper.scan(itemClass, new DynamoDBScanExpression());
    }
}
