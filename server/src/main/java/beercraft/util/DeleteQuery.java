package beercraft.util;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class DeleteQuery<T extends DatabaseItem> implements Query<Boolean> {
    protected AmazonDynamoDB databaseClient;
    private String id;
    protected Class<T> itemType;

    public DeleteQuery(AmazonDynamoDB databaseClient, String id, Class<T> itemType) {
        this.databaseClient = databaseClient;
        this.id = id;
        this.itemType = itemType;
    }

    public Boolean execute() throws IllegalAccessException, InstantiationException {
        // Create an instance of the item and set its ID so Dynamo can delete it.
        T item = itemType.newInstance();
        item.setId(id);

        DynamoDBMapper mapper = new DynamoDBMapper(databaseClient);
        mapper.delete(item);

        return true;
    }
}
