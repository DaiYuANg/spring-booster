package org.toolkit.spring.boot.starter.vertx.base;

import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;

public interface EventBusHandler<T> extends Handler<Message<T>> {
}
