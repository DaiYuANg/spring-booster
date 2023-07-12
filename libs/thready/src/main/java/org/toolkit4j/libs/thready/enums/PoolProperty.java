package org.toolkit4j.libs.thready.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor

public enum PoolProperty {
    CPU_COUNT(Runtime.getRuntime().availableProcessors()),
    QUEUE_CAPACITY(CPU_COUNT.value * 10),
    KEEP_ALIVE_TIME(60);

    @Getter
    final int value;
}
