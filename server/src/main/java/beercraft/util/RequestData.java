package beercraft.util;

import java.util.HashMap;
import java.util.Map;

/**
 * An immutable, trimmed down set of data from an HTTP request.
 */
public class RequestData {
    protected Map<String, String> queryStringParameters;
    protected String requestBody;
    private Map<String, String> pathParameters;

    public RequestData(String requestBody, Map<String, String> queryStringParameters, Map<String, String> pathParameters) {
        this.queryStringParameters = queryStringParameters;
        this.requestBody = requestBody;
        this.pathParameters = pathParameters;
    }

    /**
     * @return A copy of the request body
     */
    public String getRequestBody() {
        return new String(requestBody);
    }

    /**
     * @return A copy of the query string parameters
     */
    public Map<String, String> getQueryStringParameters() {
        return new HashMap<String, String>(queryStringParameters);
    }

    /**
     * @return A copy of the path parameters
     */
    public Map<String, String> getPathParameters() {
        return new HashMap<String, String>(pathParameters);
    }
}
