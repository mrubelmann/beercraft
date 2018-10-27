package beercraft.recipes;

import beercraft.util.*;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

import java.io.IOException;

public class DeleteRecipeRequestHandler implements RequestHandler {
    /**
     * Handles a request that was dispatched by the main Lambda handler.
     *
     * @param requestData The request body and query parameters
     * @return The response
     */
    public Response handleRequest(RequestData requestData) throws IOException, InstantiationException, IllegalAccessException {
        // TODO: Validate the input.

        AmazonDynamoDB databaseClient = AmazonDynamoDBClientBuilder.defaultClient();
        String id = requestData.getPathParameters().get("id");

        Query<Boolean> query = new DeleteQuery<>(databaseClient, id, Recipe.class);
        query.execute();
        return new Response();
    }
}
