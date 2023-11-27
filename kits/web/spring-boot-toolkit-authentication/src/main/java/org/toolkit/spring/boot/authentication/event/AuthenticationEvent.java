package org.toolkit.spring.boot.authentication.event;

import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.userdetails.UserDetails;
import org.toolkit.spring.boot.utils.struct.LoggingEvent;

@ToString
@Getter
public class AuthenticationEvent extends LoggingEvent {

	private final String token;

	private final UserDetails userDetails;

	public AuthenticationEvent(Object source, String token, UserDetails userDetails) {
		super(source);
		this.token = token;
		this.userDetails = userDetails;
	}
}
