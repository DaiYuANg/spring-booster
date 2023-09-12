package org.toolkit.spring.boot.event.bus.annotations;

import java.lang.annotation.*;

/**
 * <p>It describe for event bus address when has publish will find address in this </p>
 *
 * @author daiyuang
 * @since 0.1
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Subscribe {
	String address();
}
