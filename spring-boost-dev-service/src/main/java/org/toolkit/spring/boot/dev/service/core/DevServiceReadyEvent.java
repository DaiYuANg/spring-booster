/* (C)2023*/
package org.toolkit.spring.boot.dev.service.core;

import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@Getter
@ToString
public class DevServiceReadyEvent extends ApplicationEvent {
    public DevServiceReadyEvent(Object source) {
        super(source);
    }
}
