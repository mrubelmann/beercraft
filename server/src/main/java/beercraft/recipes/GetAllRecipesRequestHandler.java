package beercraft.recipes;

import beercraft.util.GetAllQuery;
import beercraft.util.RequestData;
import beercraft.util.RequestHandler;
import beercraft.util.Response;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class GetAllRecipesRequestHandler implements RequestHandler {
    /**
     * Handles a request that was dispatched by the main Lambda handler.
     *
     * @param requestData The request body and query parameters
     * @return The response
     */
    public Response handleRequest(RequestData requestData) throws IOException {
        AmazonDynamoDB databaseClient = AmazonDynamoDBClientBuilder.defaultClient();
        GetAllQuery<Recipe> query = new GetAllQuery<>(databaseClient, Recipe.class);

        List<Recipe> output = query.execute();

        ObjectMapper mapper = new ObjectMapper();
        return new Response(output);
    }
}
