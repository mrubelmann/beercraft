package beercraft.ingredients;

import beercraft.util.RequestData;
import beercraft.util.RequestHandler;
import beercraft.util.UpsertQuery;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class AddExtraRequestHandler implements RequestHandler {
    /**
     * Handles a request that was dispatched by the main Lambda handler.
     *
     * @param requestData The request body and query parameters
     * @return The response
     */
    public String handleRequest(RequestData requestData) throws IOException, InstantiationException, IllegalAccessException {
        // TODO: Validate the input.

        ObjectMapper mapper = new ObjectMapper();
        String requestBody = requestData.getRequestBody();
        Extra extra = mapper.readValue(requestBody, Extra.class);

        AmazonDynamoDB databaseClient = AmazonDynamoDBClientBuilder.defaultClient();
        UpsertQuery<Extra> query = new UpsertQuery<>(databaseClient, extra);

        Extra output = query.execute();
        return mapper.writeValueAsString(output);
    }
}
