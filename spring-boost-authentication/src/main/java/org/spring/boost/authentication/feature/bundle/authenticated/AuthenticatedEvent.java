/* (C)2023*/
package org.spring.boost.authentication.feature.bundle.authenticated;

import lombok.Getter;
import lombok.ToString;
import org.spring.boost.common.event.LoggingEvent;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;

@ToString
@Getter
public class AuthenticatedEvent extends LoggingEvent {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String token;

    private final UserDetails userDetails;

    public AuthenticatedEvent(Object source, String token, UserDetails userDetails) {
        super(source);
        this.token = token;
        this.userDetails = userDetails;
    }
}
