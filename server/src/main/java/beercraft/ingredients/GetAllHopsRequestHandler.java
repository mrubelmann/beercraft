package beercraft.ingredients;

import beercraft.Query;
import beercraft.RequestData;
import beercraft.RequestHandler;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class GetAllHopsRequestHandler implements RequestHandler {
    /**
     * Handles a request that was dispatched by the main Lambda handler.
     *
     * @param requestData The request body and query parameters
     * @return The response
     */
    public String handleRequest(RequestData requestData) throws IOException {
        AmazonDynamoDB databaseClient = AmazonDynamoDBClientBuilder.defaultClient();
        Query<List<Hops>> query = new GetAllHopsQuery(databaseClient);

        List<Hops> output = query.execute();

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(output);
    }
}
