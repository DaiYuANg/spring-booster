package org.toolkit.spring.boot.starter.minio.events;

import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;
import org.toolkit.spring.boot.starter.minio.functional.MinioTemplate;

@Getter
@ToString
public class ObjectUploadedEvent extends ApplicationEvent {

    private final String object;

    private final String md5;

    private final MinioTemplate template;

    public ObjectUploadedEvent(Object source, String object, String md5, MinioTemplate template) {
        super(source);
        this.object = object;
        this.md5 = md5;
        this.template = template;
    }
}
