package org.daiyuang.kernel.http;

import jdk.jfr.Experimental;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@UtilityClass
@Experimental
@Slf4j
public final class HttpUtils {
    public static void get(URI uri) {
        var cl = new OkHttpClient();
        var c = HttpClient.newBuilder().build();
        var r = HttpRequest.newBuilder().uri(uri).build();
        c.sendAsync(r, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
}
