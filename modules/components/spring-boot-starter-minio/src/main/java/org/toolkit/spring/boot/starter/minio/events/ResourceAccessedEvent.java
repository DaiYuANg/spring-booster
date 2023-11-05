package org.toolkit.spring.boot.starter.minio.events;

import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@ToString
@Getter
public class ResourceAccessedEvent extends ApplicationEvent {
    public ResourceAccessedEvent(Object source,String id) {
        super(source);
    }
}
