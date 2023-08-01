package org.toolkit4j.framework.spring.boot.starter.recording.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PerformanceRecorder {}
