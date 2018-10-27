package beercraft.ingredients;

import beercraft.util.*;

public class GetAllHopsRequestHandler implements RequestHandler {
    /**
     * Handles a request that was dispatched by the main Lambda handler.
     *
     * @param requestData The request body and query parameters
     * @return The response
     */
    public Response handleRequest(RequestData requestData) {
        return new GetAllItemsRequestHandler(Hops.class).handleRequest();
    }
}
