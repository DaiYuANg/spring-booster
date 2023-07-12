package org.toolkit4j.framework.spring.boot.starter.recording.annotation;

import org.springframework.context.annotation.Import;
import org.toolkit4j.framework.spring.boot.starter.recording.configuration.RecordingAutoConfiguration;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({RecordingAutoConfiguration.class})
@Documented
public @interface EnableRecording {

    String packages() default "";
}
