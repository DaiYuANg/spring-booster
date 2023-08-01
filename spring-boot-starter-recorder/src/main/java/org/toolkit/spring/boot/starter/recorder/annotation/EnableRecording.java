package org.toolkit.spring.boot.starter.recorder.annotation;

import java.lang.annotation.*;
import org.springframework.context.annotation.Import;
import org.toolkit.spring.boot.starter.recorder.configuration.RecordingAutoConfiguration;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({RecordingAutoConfiguration.class})
@Documented
public @interface EnableRecording {

	String packages() default "";
}
