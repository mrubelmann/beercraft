package beercraft;

import java.util.HashMap;
import java.util.Map;

/**
 * An immutable, trimmed down set of data from an HTTP request.
 */
public class RequestData {
    protected Map<String, String> queryStringParameters;
    protected String requestBody;

    public RequestData(Map<String, String> queryStringParameters, String requestBody) {
        this.queryStringParameters = queryStringParameters;
        this.requestBody = requestBody;
    }

    /**
     * @return A copy of the query string parameters
     */
    public Map<String, String> getQueryStringParameters() {
        return new HashMap<String, String>(queryStringParameters);
    }

    /**
     * @return A copy of the request body
     */
    public String getRequestBody() {
        return new String(requestBody);
    }
}
