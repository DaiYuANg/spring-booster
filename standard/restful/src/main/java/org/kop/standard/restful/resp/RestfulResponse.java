package org.kop.standard.restful.resp;

import jakarta.ws.rs.core.Response;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@ToString
@Accessors(chain = true)
public class RestfulResponse implements Serializable {
    private Response response;

    private String message;

    private long timestamp = System.currentTimeMillis();

    private RestfulResponse() {
    }

    public static RestfulResponse response(Response response, String message) {
        return new RestfulResponse().setResponse(response).setMessage(message);
    }

    public static RestfulResponse ok() {
        return new RestfulResponse()
                .setResponse(Response.noContent()
                        .status(Response.Status.OK)
                        .build());
    }

    public static RestfulResponse ok(Object data) {
        return new RestfulResponse().setResponse(Response.ok(data).build());
    }

    public static RestfulResponse ok(Object data, String message) {
        return new RestfulResponse()
                .setResponse(Response.ok(data).build())
                .setMessage(message);
    }

    public static RestfulResponse err() {
        return new RestfulResponse()
                .setResponse(Response.serverError().build());
    }

    public static RestfulResponse err(String message) {
        return new RestfulResponse()
                .setMessage(message)
                .setResponse(Response.serverError().build());
    }

    public static RestfulResponse unAuth() {
        return new RestfulResponse()
                .setResponse(Response.status(Response.Status.UNAUTHORIZED).build());
    }
}