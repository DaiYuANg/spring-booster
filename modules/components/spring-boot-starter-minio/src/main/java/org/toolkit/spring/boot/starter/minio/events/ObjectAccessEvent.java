package org.toolkit.spring.boot.starter.minio.events;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@ToString
@Getter
public class ObjectAccessEvent extends ApplicationEvent {
    private final String path;

    private final HttpServletRequest request;

    public ObjectAccessEvent(Object source, String path, HttpServletRequest request) {
        super(source);
        this.path = path;
        this.request = request;
    }
}
