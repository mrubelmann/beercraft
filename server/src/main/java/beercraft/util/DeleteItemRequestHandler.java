package beercraft.util;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

import java.io.IOException;

public class DeleteItemRequestHandler<T extends DatabaseItem> {
    private Class<T> itemType;

    public DeleteItemRequestHandler(Class<T> itemType) {
        this.itemType = itemType;
    }

    public Response handleRequest(RequestData requestData) throws IOException, InstantiationException, IllegalAccessException {
        AmazonDynamoDB databaseClient = AmazonDynamoDBClientBuilder.defaultClient();
        String id = requestData.getPathParameters().get("id");

        Query<Boolean> query = new DeleteQuery<>(databaseClient, id, itemType);
        query.execute();

        return new Response();
    }
}
