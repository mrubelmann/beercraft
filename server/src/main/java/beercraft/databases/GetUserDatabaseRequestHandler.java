package beercraft.databases;

import beercraft.ingredients.GetGlobalIngredientsQuery;
import beercraft.util.*;
import com.amazonaws.services.dynamodbv2.document.Table;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetUserDatabaseRequestHandler implements RequestHandler {
    static final Logger logger = LogManager.getLogger(GetUserDatabaseRequestHandler.class);

    /**
     * Handles a request that was dispatched by the main Lambda handler.
     *
     * @param requestData The request body and query parameters
     * @return The response
     */
    public Response handleRequest(RequestData requestData) {
        logger.debug("Handling request to get user database");

        // TODO: Validate user

        // Initialize all the queries for the worker to use.
        Table table = DynamoDbConnectionFactory.getConnectionToTable("Beercraft");

        // Do it.
        GetUserDatabaseRequestWorker worker = new GetUserDatabaseRequestWorker(new GetGlobalIngredientsQuery(table));
        String result = worker.execute();

        return new Response(result);
    }
}
