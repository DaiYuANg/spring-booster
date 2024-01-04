/* (C)2012-2023*/
package org.toolkit.spring.boot.dev.service.lifecycle;

import static java.util.Collections.unmodifiableSet;

import com.google.common.collect.ImmutableSet;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.SpringApplicationAotProcessor;
import org.springframework.util.ClassUtils;

/**
 * Checks if Docker Compose support should be skipped.
 *
 * @author Phillip Webb
 */
@Slf4j
class DevServiceSkipCheck {

    private static final Set<String> REQUIRED_CLASSES = Set.of("org.junit.jupiter.api.Test", "org.junit.Test");

    private static final Set<String> SKIPPED_STACK_ELEMENTS;

    static {
        val skipped = new LinkedHashSet<>(ImmutableSet.of(
                "org.junit.runners.",
                "org.junit.platform.",
                "org.springframework.boot.test.",
                SpringApplicationAotProcessor.class.getName(),
                "cucumber.runtime."));
        SKIPPED_STACK_ELEMENTS = unmodifiableSet(skipped);
    }

    public static boolean shouldSkip(ClassLoader classLoader) {
        if (!hasAtLeastOneRequiredClass(classLoader)) {
            return false;
        }
        Thread thread = Thread.currentThread();
        return Arrays.stream(thread.getStackTrace()).anyMatch(DevServiceSkipCheck::isSkippedStackElement);
    }

    private static boolean hasAtLeastOneRequiredClass(ClassLoader classLoader) {
        return REQUIRED_CLASSES.stream().anyMatch(requiredClass -> ClassUtils.isPresent(requiredClass, classLoader));
    }

    private static boolean isSkippedStackElement(StackTraceElement element) {
        return SKIPPED_STACK_ELEMENTS.stream()
                .anyMatch(skipped -> element.getClassName().startsWith(skipped));
    }
}
