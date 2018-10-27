package beercraft.recipes;

import beercraft.util.*;

public class GetAllStylesRequestHandler implements RequestHandler {
    /**
     * Handles a request that was dispatched by the main Lambda handler.
     *
     * @param requestData The request body and query parameters
     * @return The response
     */
    public Response handleRequest(RequestData requestData) {
        return new GetAllItemsRequestHandler(Style.class).handleRequest();
    }
}
