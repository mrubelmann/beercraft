package beercraft.users;

import beercraft.ingredients.GetGlobalIngredientsQuery;
import beercraft.util.*;
import com.amazonaws.services.dynamodbv2.document.Table;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Handles GET requests to /users/{userId}/database.
 */
public class GetUserDatabaseRequestHandler implements RequestHandler {
    static final Logger logger = LogManager.getLogger(GetUserDatabaseRequestHandler.class);

    /**
     * Handles the request
     * @param requestData The request body and query parameters
     * @return The response
     */
    public Response handleRequest(RequestData requestData) {
        logger.debug("GET /users/{userId}/database");
        logger.debug(String.format("Request data: %s", requestData));

        // TODO: Validate user
        String userId = requestData.getPathParameters().get("userId");

        // Initialize all the queries for the worker to use.
        Table table = DynamoDbConnectionFactory.getConnectionToTable("Beercraft");

        // Do it.
        GetUserDatabaseRequestWorker worker = new GetUserDatabaseRequestWorker(
                new GetGlobalIngredientsQuery(table),
                new GetUserQuery(table, userId)
        );
        return new Response(worker.execute());
    }
}
