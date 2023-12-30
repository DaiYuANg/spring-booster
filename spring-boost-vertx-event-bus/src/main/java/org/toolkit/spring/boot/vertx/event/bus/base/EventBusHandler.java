/* (C)2023*/
package org.toolkit.spring.boot.vertx.event.bus.base;

import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;

public interface EventBusHandler<T> extends Handler<Message<T>> {}
