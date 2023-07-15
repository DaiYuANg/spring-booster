package org.toolkit4J.framework.spring.starter.authentication.events;

import org.toolkit4J.framework.spring.starter.authentication.entities.UserEntity;
import org.toolkit4J.framework.spring.starter.event.spring.base.CompareTimingEvent;

public class UserDomainEvent extends CompareTimingEvent<UserEntity> {
    public UserDomainEvent(Object source, UserEntity data) {
        super(source, data);
    }
}
