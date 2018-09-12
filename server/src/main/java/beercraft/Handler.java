package beercraft;

import beercraft.ingredients.AddFermentableRequestHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Handler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {
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
            switch(resource) {
                case "/debug":
                    Response responseBody = new Response("Time to brew some beer!", input);
                    return ApiGatewayResponse.builder()
                            .setStatusCode(200)
                            .setObjectBody(responseBody)
                            .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & serverless"))
                            .build();
                case "/fermentables":
                    RequestData data = new RequestData(new HashMap<String, Object>(), (String)input.get("body"));
                    beercraft.RequestHandler handler = new AddFermentableRequestHandler();
                    String result = handler.handleRequest(data);
                    return ApiGatewayResponse.builder()
                            .setStatusCode(200)
                            .setObjectBody(result)
                            .build();
                default:
                    return ApiGatewayResponse.builder()
                            .setStatusCode(400)
                            .setObjectBody("Not implemented")
                            .build();
            }
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
