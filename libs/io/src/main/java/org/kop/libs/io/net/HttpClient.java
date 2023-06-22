package org.kop.libs.io.net;

import jdk.jfr.Experimental;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.val;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.File;

@Experimental
@Getter
public class HttpClient {
    private final OkHttpClient client;

    private static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    private int cacheSize = 10 * 1024 * 1024;

    private Cache cache = new Cache(new File(System.getProperty("java.io.tmpdir")), this.cacheSize);

    public HttpClient(OkHttpClient.@NotNull Builder builder) {
        this.client = builder.cache(cache).build();
    }

    public HttpClient(OkHttpClient.@NotNull Builder builder, int cacheSize) {
        this.cacheSize = cacheSize;
        this.client = builder.cache(cache).build();
    }

    public HttpClient(OkHttpClient.@NotNull Builder builder, Cache cache) {
        this.client = builder.cache(cache).build();
        this.cache = cache;
    }

    @SneakyThrows
    public Response get(Request.@NotNull Builder reqBuilder) {
        val req = reqBuilder.get().build();
        return exec(req);
    }

    public Response get(String url) {
        val req = new Request.Builder().url(url).get().build();
        return exec(req);
    }

    @SneakyThrows
    public Response exec(Request req) {
        try (val resp = client.newCall(req).execute()) {
            return resp;
        }
    }

    public Response postJson(Request.@NotNull Builder reqBuilder, String json) {
        RequestBody body = RequestBody.create(json, JSON);
        val req = reqBuilder.post(body).build();
        return exec(req);
    }
}
