package beercraft.ingredients;

import beercraft.util.*;

import java.io.IOException;

public class AddYeastRequestHandler implements RequestHandler {
    /**
     * Handles a request that was dispatched by the main Lambda handler.
     *
     * @param requestData The request body and query parameters
     * @return The response
     */
    public Response handleRequest(RequestData requestData) throws IOException {
        // TODO: Validate the input.

        return new AddItemRequestHandler(Yeast.class).handleRequest(requestData);
    }
}
