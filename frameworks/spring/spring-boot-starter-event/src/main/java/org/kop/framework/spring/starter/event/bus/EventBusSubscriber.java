package org.kop.framework.spring.starter.event.bus;

public interface EventBusSubscriber {
    void onBus(Object o);
}
