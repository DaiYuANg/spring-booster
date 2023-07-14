package org.toolkit4j.framework.spring.boot.starter.notification.ws;

import jakarta.websocket.*;
import java.util.concurrent.CopyOnWriteArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.toolkit4j.standard.communication.Websocket;

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
	public void onMessage(String message) {}

	@OnClose
	public void onClose(Session throwable) {
		sockets.remove(this);
	}

	@OnError
	public void onError(Throwable throwable) {}
}
