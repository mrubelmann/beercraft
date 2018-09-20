package beercraft.ingredients;

import beercraft.Query;
import beercraft.RequestData;
import beercraft.RequestHandler;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

import java.io.IOException;

public class DeleteFermentableRequestHandler implements RequestHandler {
    /**
     * Handles a request that was dispatched by the main Lambda handler.
     *
     * @param requestData The request body and query parameters
     * @return The response
     */
    public String handleRequest(RequestData requestData) throws IOException {
        // TODO: Validate the input.

        AmazonDynamoDB databaseClient = AmazonDynamoDBClientBuilder.defaultClient();
        String id = requestData.getPathParameters().get("id");
        Query<Boolean> query = new DeleteFermentableQuery(databaseClient, id);

        query.execute();
        return "";
    }
}
