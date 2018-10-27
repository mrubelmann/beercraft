package beercraft;

import beercraft.ingredients.*;
import beercraft.recipes.*;
import beercraft.util.ApiGatewayResponse;
import beercraft.util.RequestData;
import beercraft.util.Response;
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
                new Endpoint("/fermentables", "POST", AddFermentableRequestHandler.class),
                new Endpoint("/fermentables/{id}", "PUT", AddFermentableRequestHandler.class),
                new Endpoint("/fermentables", "GET", GetAllFermentablesRequestHandler.class),
                new Endpoint("/fermentables/{id}", "DELETE", DeleteFermentableRequestHandler.class),
                new Endpoint("/hops", "POST", AddHopsRequestHandler.class),
                new Endpoint("/hops/{id}", "PUT", AddHopsRequestHandler.class),
                new Endpoint("/hops", "GET", GetAllHopsRequestHandler.class),
                new Endpoint("/hops/{id}", "DELETE", DeleteHopsRequestHandler.class),
                new Endpoint("/extras", "POST", AddExtraRequestHandler.class),
                new Endpoint("/extras/{id}", "PUT", AddExtraRequestHandler.class),
                new Endpoint("/extras", "GET", GetAllExtrasRequestHandler.class),
                new Endpoint("/extras/{id}", "DELETE", DeleteExtraRequestHandler.class),
                new Endpoint("/yeast", "POST", AddYeastRequestHandler.class),
                new Endpoint("/yeast/{id}", "PUT", AddYeastRequestHandler.class),
                new Endpoint("/yeast", "GET", GetAllYeastRequestHandler.class),
                new Endpoint("/yeast/{id}", "DELETE", DeleteYeastRequestHandler.class),
                new Endpoint("/recipes", "POST", AddRecipeRequestHandler.class),
                new Endpoint("/recipes/{id}", "PUT", AddRecipeRequestHandler.class),
                new Endpoint("/recipes", "GET", GetAllRecipesRequestHandler.class),
                new Endpoint("/recipes/{id}", "DELETE", DeleteRecipeRequestHandler.class),
                new Endpoint("/styles", "POST", AddStyleRequestHandler.class),
                new Endpoint("/styles/{id}", "PUT", UpdateStyleRequestHandler.class),
                new Endpoint("/styles", "GET", GetAllStylesRequestHandler.class),
                new Endpoint("/styles/{id}", "DELETE", DeleteStyleRequestHandler.class)
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
            Map<String, String> pathParams = (Map<String, String>)input.get("pathParameters");

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
            return ApiGatewayResponse.builder()
                    .setObjectBody(e.toString())
                    .setStatusCode(500)
                    .build();
        }
    }
}

