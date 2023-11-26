package org.toolkit.spring.boot.authentication.event;

import lombok.Getter;
import lombok.ToString;
import org.toolkit.spring.boot.utils.struct.LoggingEvent;

@ToString
@Getter
public class AuthenticationEvent extends LoggingEvent {
    public AuthenticationEvent(Object source) {
        super(source);
    }
}
