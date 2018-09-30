package beercraft.ingredients;

import beercraft.util.DeleteQuery;
import beercraft.util.Query;
import beercraft.util.RequestData;
import beercraft.util.RequestHandler;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

import java.io.IOException;

public class DeleteYeastRequestHandler implements RequestHandler {
    /**
     * Handles a request that was dispatched by the main Lambda handler.
     *
     * @param requestData The request body and query parameters
     * @return The response
     */
    public String handleRequest(RequestData requestData) throws IOException, InstantiationException, IllegalAccessException {
        // TODO: Validate the input.

        AmazonDynamoDB databaseClient = AmazonDynamoDBClientBuilder.defaultClient();
        String id = requestData.getPathParameters().get("id");

        Query<Boolean> query = new DeleteQuery<>(databaseClient, id, Yeast.class);
        query.execute();
        return "";
    }
}
