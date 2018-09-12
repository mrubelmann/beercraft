package beercraft;

import java.util.HashMap;
import java.util.Map;

/**
 * An immutable, trimmed down set of data from an HTTP request.
 */
public class RequestData {
    protected Map<String, Object> queryStringParameters;
    protected String requestBody;

    public RequestData(Map<String, Object> queryStringParameters, String requestBody) {
        this.queryStringParameters = queryStringParameters;
        this.requestBody = requestBody;
    }

    /**
     * @return A copy of the query string parameters
     */
    public Map<String, Object> getQueryStringParameters() {
        return new HashMap<String, Object>(queryStringParameters);
    }

    /**
     * @return A copy of the request body
     */
    public String getRequestBody() {
        return new String(requestBody);
    }
}
