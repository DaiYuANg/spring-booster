package org.toolkit.spring.boot.event.bus.annotations;

import java.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * <p>It for spring component scanner position event object</p>
 * <p>when set this annotation the event bus register will deploy this object in vertx</p>
 * @author daiyuang
 * @since 0.1
 */
@Component
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Subscriber {
	String address();
}
