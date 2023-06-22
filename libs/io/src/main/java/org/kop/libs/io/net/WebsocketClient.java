package org.kop.libs.io.net;

import jakarta.json.JsonObject;
import jdk.jfr.Experimental;
import lombok.val;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

@Experimental
public class WebsocketClient {

    private final WebSocket ws;

    public WebsocketClient(String url, WebSocketListener listener) {
        val client = new OkHttpClient.Builder()
                .pingInterval(10, TimeUnit.SECONDS)
                .build();
        val req = new Request.Builder()
                .url(url)
                .build();
        ws = client.newWebSocket(req, listener);
    }

    public void send(String data) {
        ws.send(data);
    }

    public void send(@NotNull JsonObject data) {
        ws.send(data.toString());
    }
}