package org.toolkit.spring.boot.starter.minio.shared.events;

import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;
import org.toolkit.spring.boot.starter.minio.shared.template.IMinioTemplate;

@Getter
@ToString
public class ObjectUploadedEvent extends ApplicationEvent {

    private final String object;

    private final String md5;

    private final IMinioTemplate template;

    public ObjectUploadedEvent(Object source, String object, String md5, IMinioTemplate template) {
        super(source);
        this.object = object;
        this.md5 = md5;
        this.template = template;
    }
}
