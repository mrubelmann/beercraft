package beercraft.util;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class AddItemRequestHandler<T> {
    private Class<T> itemType;

    public AddItemRequestHandler(Class<T> itemType) {
        this.itemType = itemType;
    }

    public Response handleRequest(RequestData requestData) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String requestBody = requestData.getRequestBody();
        T item = mapper.readValue(requestBody, itemType);

        AmazonDynamoDB databaseClient = AmazonDynamoDBClientBuilder.defaultClient();
        UpsertQuery<T> query = new UpsertQuery<>(databaseClient, item);
        T output = query.execute();

        return new Response(output);
    }
}
