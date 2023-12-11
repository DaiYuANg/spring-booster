package org.toolkit.spring.boot.route.event;

import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;
import org.toolkit.spring.boot.route.entity.RouteEntity;

@Getter
@ToString
public class RouteAddEvent extends ApplicationEvent {
	private final RouteEntity routeEntity;

	public RouteAddEvent(Object source, RouteEntity routeEntity) {
		super(source);
		this.routeEntity = routeEntity;
	}
}
