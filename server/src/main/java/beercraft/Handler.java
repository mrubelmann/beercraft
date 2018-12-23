package beercraft;

import beercraft.users.GetUserDatabaseRequestHandler;
import beercraft.util.ApiGatewayResponse;
import beercraft.util.RequestData;
import beercraft.util.Response;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Handler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {
    static final Logger logger = LogManager.getLogger(Handler.class);

    protected class Endpoint {
        private final String resource;
        private final String method;
        private final Class handlerClass;

        public Endpoint(String resource, String method, Class handlerClass) {
            this.resource = resource;
            this.method = method;
            this.handlerClass = handlerClass;
        }

        public String getResource() {
            return resource;
        }

        public String getMethod() {
            return method;
        }

        public Class getHandlerClass() {
            return handlerClass;
        }
    }

    private List<Endpoint> endpoints;

    public Handler() {
        this.endpoints = new ArrayList<>();
        this.endpoints.add(new Endpoint("/users/{userId}/database", "GET", GetUserDatabaseRequestHandler.class));
        // [NEW ENDPOINTS GO HERE]
    }

    /**
     * Handles a Lambda Function request
     *
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return The Lambda Function output
     */
    public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
        try {
            String resource = (String)input.get("resource");
            String method = (String)input.get("httpMethod");
            Map<String, String> queryParams = (Map<String, String>)input.get("queryStringParameters");
            String body = (String)input.get("body");
            Map<String, String> pathParams = (Map<String, String>)input.get("pathParameters");

            // See if the method and route match one of the predefined endpoints.
            Endpoint endpoint = endpoints.stream()
                    .filter(x -> x.getMethod().equals(method) && x.getResource().equals(resource))
                    .findFirst()
                    .orElse(null);
            if (endpoint == null) {
                logger.error(String.format("No matching endpoint found for %s %s", method, resource));
                return ApiGatewayResponse.builder()
                        .setStatusCode(400)
                        .setObjectBody(endpoints)
                        .build();
            }

            // Instantiate a handler for the request.
            beercraft.util.RequestHandler handler = (beercraft.util.RequestHandler)endpoint.handlerClass.newInstance();
            RequestData requestData = new RequestData(body, queryParams, pathParams);

            // Execute the handler.
            Response response = handler.handleRequest(requestData);
            return ApiGatewayResponse.builder()
                    .setObjectBody(response.getBody())
                    .setStatusCode(response.getStatusCode())
                    .build();
        }
        catch(Exception e) {
            logger.error("Unhandled exception", e);
            return ApiGatewayResponse.builder()
                    .setStatusCode(500)
                    .setObjectBody(e.toString())
                    .build();
        }
    }
}

