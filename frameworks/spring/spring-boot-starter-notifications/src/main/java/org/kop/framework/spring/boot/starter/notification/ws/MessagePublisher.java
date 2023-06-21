package org.kop.framework.spring.boot.starter.notification.ws;

import jakarta.websocket.*;
import lombok.extern.slf4j.Slf4j;
import org.kop.standard.communication.Websocket;
import org.springframework.stereotype.Component;

import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Slf4j
public class MessagePublisher extends Websocket<MessagePublisher> {
    private static final CopyOnWriteArrayList<MessagePublisher> sockets = new CopyOnWriteArrayList<>();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        sockets.add(this);
    }

    @OnMessage
    public void onMessage(String message) {
    }

    @OnClose
    public void onClose(Session throwable) {
        sockets.remove(this);
    }

    @OnError
    public void onError(Throwable throwable) {
    }
}
