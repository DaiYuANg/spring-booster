/* (C)2024*/
package org.spring.boost.minio.event;

import io.minio.ObjectWriteResponse;
import java.io.Serial;
import lombok.Getter;
import lombok.ToString;
import org.spring.boost.core.event.LoggingEvent;

@ToString
@Getter
public class ObjectCreateEvent extends LoggingEvent {

    @Serial
    private static final long serialVersionUID = 1L;

    private final ObjectWriteResponse response;

    public ObjectCreateEvent(Object source, ObjectWriteResponse response) {
        super(source);
        this.response = response;
    }
}
