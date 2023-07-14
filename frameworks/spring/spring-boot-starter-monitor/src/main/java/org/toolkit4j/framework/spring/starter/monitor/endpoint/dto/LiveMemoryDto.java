package org.toolkit4j.framework.spring.starter.monitor.endpoint.dto;

import java.lang.management.MemoryUsage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class LiveMemoryDto {
	private MemoryUsage HeapMemoryUsage;
	private MemoryUsage NonHeapMemoryUsage;
}
