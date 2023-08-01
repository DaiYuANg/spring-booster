package org.toolkit.spring.boot.authentication.events;

import org.toolkit.spring.boot.authentication.entities.UserEntity;
import org.toolkit.spring.boot.starter.event.spring.base.CompareTimingEvent;

public class UserDomainEvent extends CompareTimingEvent<UserEntity> {
	public UserDomainEvent(Object source, UserEntity data) {
		super(source, data);
	}
}
