/*
 * Copyright 2012-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.toolkit.spring.boot.dev.service.lifecycle;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.SpringApplicationAotProcessor;
import org.springframework.util.ClassUtils;

import static java.util.Collections.unmodifiableSet;

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
                "cucumber.runtime."
        ));
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
