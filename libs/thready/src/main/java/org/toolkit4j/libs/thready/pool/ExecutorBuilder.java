package org.toolkit4j.libs.thready.pool;

import lombok.Builder;
import lombok.Getter;
import org.toolkit4j.libs.thready.enums.PoolProperty;

@Builder
@Getter
public class ExecutorBuilder {
	@Builder.Default
    private int coreSize = PoolProperty.CPU_COUNT.getValue() + 1;
}
