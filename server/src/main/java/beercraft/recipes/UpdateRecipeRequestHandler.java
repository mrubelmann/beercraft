package beercraft.recipes;

import beercraft.util.RequestData;
import beercraft.util.RequestHandler;
import beercraft.util.Response;
import beercraft.util.UpdateItemRequestHandler;

import java.io.IOException;

public class UpdateRecipeRequestHandler implements RequestHandler {
    /**
     * Handles a request that was dispatched by the main Lambda handler.
     *
     * @param requestData The request body and query parameters
     * @return The response
     */
    public Response handleRequest(RequestData requestData) throws IOException {
        // TODO: Validate the input.

        return new UpdateItemRequestHandler<>(Recipe.class).handleRequest(requestData);
    }
}
