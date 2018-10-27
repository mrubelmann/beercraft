package beercraft.util;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

import java.util.List;

public class GetAllItemsRequestHandler<T> {
    private Class<T> itemType;

    public GetAllItemsRequestHandler(Class<T> itemType) {
        this.itemType = itemType;
    }

    public Response handleRequest() {
        AmazonDynamoDB databaseClient = AmazonDynamoDBClientBuilder.defaultClient();
        GetAllQuery<T> query = new GetAllQuery<>(databaseClient, itemType);
        List<T> output = query.execute();

        return new Response(output);
    }
}
