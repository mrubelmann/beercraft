package beercraft.util;

public class Response {
    private Object body;
    private int statusCode;

    public Response() {
        this.body = "";
        this.statusCode = 200;
    }

    public Response(Object body) {
        this.body = body;
        this.statusCode = 200;
    }

    public Response(Object body, int statusCode) {
        this.body = body;
        this.statusCode = statusCode;
    }

    public Object getBody() {
        return body;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
