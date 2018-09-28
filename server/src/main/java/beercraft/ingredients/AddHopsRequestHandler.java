package beercraft.ingredients;

import beercraft.util.RequestData;
import beercraft.util.RequestHandler;
import beercraft.util.UpsertQuery;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class AddHopsRequestHandler implements RequestHandler {
    /**
     * Handles a request that was dispatched by the main Lambda handler.
     *
     * @param requestData The request body and query parameters
     * @return The response
     */
    public String handleRequest(RequestData requestData) throws IOException {
        // TODO: Validate the input.

        ObjectMapper mapper = new ObjectMapper();
        String requestBody = requestData.getRequestBody();
        Hops hops = mapper.readValue(requestBody, Hops.class);

        AmazonDynamoDB databaseClient = AmazonDynamoDBClientBuilder.defaultClient();
        UpsertQuery<Hops> query = new UpsertQuery<>(databaseClient, hops);

        Hops output = query.execute();
        return mapper.writeValueAsString(output);
    }
}
