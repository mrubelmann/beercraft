package beercraft.recipes;

import beercraft.util.*;
import com.amazonaws.services.dynamodbv2.document.Table;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Handles POST requests to /recipes.
 */
public class CreateRecipeRequestHandler implements RequestHandler {
    static final Logger logger = LogManager.getLogger(CreateRecipeRequestHandler.class);

    /**
     * Handles the request
     * @param requestData The request body and query parameters
     * @return The response
     */
    public Response handleRequest(RequestData requestData) {
        logger.debug("POST /recipes");
        logger.debug(String.format("Request data: %s", requestData));

        // TODO: Validate input.

        // TODO: Instantiate queries for worker.
        // Table table = DynamoDbConnectionFactory.getConnectionToTable("Beercraft");

        // Run the worker.
        CreateRecipeRequestWorker worker = new CreateRecipeRequestWorker();
        return new Response(worker.execute());
    }
}
