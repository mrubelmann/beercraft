package beercraft.util;

import java.io.IOException;

public interface RequestHandler {
    /**
     * Handles a request that was dispatched by the main Lambda handler.
     *
     * @param requestData The request body and query parameters
     * @return The response
     */
    Response handleRequest(RequestData requestData) throws InstantiationException, IllegalAccessException, IOException;
}
