package beercraft.util;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class UpsertQuery<T> implements Query<T> {
    protected AmazonDynamoDB databaseClient;
    protected T item;

    public UpsertQuery(AmazonDynamoDB databaseClient, T item) {
        this.databaseClient = databaseClient;
        this.item = item;
    }

    public T execute() {
        DynamoDBMapper mapper = new DynamoDBMapper(databaseClient);
        mapper.save(item);
        return item;
    }
}
