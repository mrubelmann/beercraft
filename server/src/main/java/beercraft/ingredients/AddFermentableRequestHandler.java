package beercraft.ingredients;

import beercraft.Query;
import beercraft.RequestData;
import beercraft.RequestHandler;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

public class AddFermentableRequestHandler implements RequestHandler {
    /**
     * Handles a request that was dispatched by the main Lambda handler.
     *
     * @param requestData The request body and query parameters
     * @return The response
     */
    public String handleRequest(RequestData requestData) {
        // TODO: Validate the input.

        // TODO: Deserialize the request body into a Fermentable object.
        Fermentable fermentable = new Fermentable();
        fermentable.setName("Crystal 20L");

        AmazonDynamoDB databaseClient = AmazonDynamoDBClientBuilder.defaultClient();
        Query<Fermentable> query = new AddFermentableQuery(databaseClient, fermentable);

        // TODO: Serialize the output.
        Fermentable output = query.execute();

        return "{ \"Id\": \"" + output.getId() + "\", \"Name\": \"" + output.getName() + "\" }";
    }
}
