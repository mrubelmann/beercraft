package beercraft.recipes;

import beercraft.util.*;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

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
    public Response handleRequest(RequestData requestData) throws IOException {
        logger.debug("POST /recipes");
        logger.debug(String.format("Request data: %s", requestData));

        // TODO: Validate input.

        // Parse request body.
        ObjectMapper mapper = ObjectMapperSingleton.getInstance();
        Recipe recipe = mapper.readValue(requestData.getRequestBody(), Recipe.class);

        // Establish database connection.
        AmazonDynamoDB databaseClient = AmazonDynamoDBClientBuilder.defaultClient();

        // Instantiate queries for worker.
        CreateRecipeQuery createRecipeQuery = new CreateRecipeQuery(databaseClient);

        // Run the worker.
        CreateRecipeRequestWorker worker = new CreateRecipeRequestWorker(createRecipeQuery);
        worker.execute(recipe);

        return new Response(recipe);
    }
}
