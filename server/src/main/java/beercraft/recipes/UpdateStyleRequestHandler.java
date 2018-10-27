package beercraft.recipes;

import beercraft.util.GetByIdQuery;
import beercraft.util.RequestData;
import beercraft.util.RequestHandler;
import beercraft.util.UpsertQuery;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

public class UpdateStyleRequestHandler implements RequestHandler {
    /**
     * Handles a request that was dispatched by the main Lambda handler.
     *
     * @param requestData The request body and query parameters
     * @return The response
     */
    public String handleRequest(RequestData requestData) throws IOException, InstantiationException, IllegalAccessException {
        // TODO: Validate the input.

        AmazonDynamoDB databaseClient = AmazonDynamoDBClientBuilder.defaultClient();
        ObjectMapper mapper = new ObjectMapper();

        // Ensure the record being updated exists.
        String id = requestData.getPathParameters().get("id");
        GetByIdQuery<Style> getByIdQuery = new GetByIdQuery<>(databaseClient, id, Style.class);
        boolean exists = getByIdQuery.execute().isPresent();

        if(exists) {
            // Get the new style from the body and set the ID.
            String requestBody = requestData.getRequestBody();
            Style style = mapper.readValue(requestBody, Style.class);
            style.setId(id);

            UpsertQuery<Style> query = new UpsertQuery<>(databaseClient, style);

            return mapper.writeValueAsString(query.execute());
        }
        else {
            return "OMG IT'S NOT THERE";
        }
    }
}
