package beercraft.ingredients;

import beercraft.util.RequestData;
import beercraft.util.RequestHandler;
import beercraft.util.Response;
import beercraft.util.UpsertQuery;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class AddFermentableRequestHandler implements RequestHandler {
    /**
     * Handles a request that was dispatched by the main Lambda handler.
     *
     * @param requestData The request body and query parameters
     * @return The response
     */
    public Response handleRequest(RequestData requestData) throws IOException {
        // TODO: Validate the input.

        ObjectMapper mapper = new ObjectMapper();
        String requestBody = requestData.getRequestBody();
        Fermentable fermentable = mapper.readValue(requestBody, Fermentable.class);

        AmazonDynamoDB databaseClient = AmazonDynamoDBClientBuilder.defaultClient();
        UpsertQuery<Fermentable> query = new UpsertQuery<>(databaseClient, fermentable);

        Fermentable output = query.execute();
        return new Response(output);
    }
}
