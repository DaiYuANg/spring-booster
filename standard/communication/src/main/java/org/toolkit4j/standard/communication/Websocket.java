package org.toolkit4j.standard.communication;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;
import jakarta.websocket.Session;
import lombok.SneakyThrows;
import lombok.val;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;
import java.util.Collection;

public abstract class Websocket<WS extends Websocket<WS>> {
    protected volatile Session session;

    @SneakyThrows
    protected synchronized void send(String data) {
        session.getBasicRemote().sendText(data);
    }

    @SneakyThrows
    protected synchronized void send(Object data) {
        session.getBasicRemote().sendObject(data);
    }

    @SneakyThrows
    protected synchronized void send(ByteBuffer data) {
        session.getBasicRemote().sendBinary(data);
    }

    @SneakyThrows
    protected synchronized void send(ByteBuffer data, boolean isLast) {
        session.getBasicRemote().sendBinary(data, isLast);
    }

    protected void send(@NotNull JsonObject data) {
        send(data.toString());
    }

    protected void send(Collection<Object> data) {
        val converted = Json.createArrayBuilder(data).build()
                .stream()
                .map(JsonValue::asJsonObject)
                .map(JsonObject::toString)
                .toList()
                .toString();
        send(converted);
    }
}
