/* (C)2024*/
package org.spring.boost.minio.event;

import io.minio.ObjectWriteResponse;
import lombok.Getter;
import lombok.ToString;
import org.spring.boost.common.struct.LoggingEvent;

import java.io.Serial;

@ToString
@Getter
public class ObjectCreateEvent extends LoggingEvent {

    @Serial
    private final static long serialVersionUID = 1L;

    private final ObjectWriteResponse response;

    public ObjectCreateEvent(Object source, ObjectWriteResponse response) {
        super(source);
        this.response = response;
    }
}
