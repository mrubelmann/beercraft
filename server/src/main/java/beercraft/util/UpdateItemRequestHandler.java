package beercraft.util;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class UpdateItemRequestHandler<T extends DatabaseItem> {
    private Class<T> itemType;

    public UpdateItemRequestHandler(Class<T> itemType) {
        this.itemType = itemType;
    }

    public Response handleRequest(RequestData requestData) throws IOException {
        AmazonDynamoDB databaseClient = AmazonDynamoDBClientBuilder.defaultClient();
        ObjectMapper mapper = new ObjectMapper();

        // Ensure the record being updated exists.
        String id = requestData.getPathParameters().get("id");
        GetByIdQuery<T> getByIdQuery = new GetByIdQuery<>(databaseClient, id, itemType);
        boolean exists = getByIdQuery.execute().isPresent();

        if(exists) {
            // Get the new item from the body and set the ID.
            String requestBody = requestData.getRequestBody();
            T item = mapper.readValue(requestBody, itemType);
            item.setId(id);

            UpsertQuery<T> query = new UpsertQuery<>(databaseClient, item);

            return new Response(query.execute());
        }
        else {
            return new Response("Item not found: " + id, 404);
        }
    }
}
