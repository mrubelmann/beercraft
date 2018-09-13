package beercraft;

import beercraft.ingredients.AddFermentableRequestHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.util.*;

public class Handler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {
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
        this.endpoints = Arrays.asList(
                new Endpoint("/fermentables", "POST", AddFermentableRequestHandler.class)
        );
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

            // TODO: Remove this.  It's just for testing.
            if (resource.contains("debug")) {
                Response responseBody = new Response("Time to brew some beer!", input);
                return ApiGatewayResponse.builder().setObjectBody(responseBody).build();
            }

            // See if the method and route match one of the predefined endpoints.
            Endpoint endpoint = endpoints.stream()
                    .filter(x -> x.getMethod().equals(method) && x.getResource().equals(resource))
                    .findFirst()
                    .orElse(null);
            if (endpoint == null) {
                return ApiGatewayResponse.builder()
                        .setStatusCode(400)
                        .setObjectBody(endpoints)
                        .build();
            }

            // Instantiate a handler for the request.
            beercraft.RequestHandler handler = (beercraft.RequestHandler)endpoint.handlerClass.newInstance();
            RequestData requestData = new RequestData(queryParams, body);

            // Execute the handler.
            String result = handler.handleRequest(requestData);
            return ApiGatewayResponse.builder().setObjectBody(result).build();
        }
        catch(Exception e) {
            // TODO: Return something better.
            return ApiGatewayResponse.builder()
                    .setStatusCode(500)
                    .setObjectBody("Something went wrong.")
                    .build();
        }
    }
}
