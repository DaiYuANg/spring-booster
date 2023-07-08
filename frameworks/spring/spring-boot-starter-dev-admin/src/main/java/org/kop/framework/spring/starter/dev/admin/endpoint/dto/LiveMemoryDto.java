package org.kop.framework.spring.starter.dev.admin.endpoint.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.lang.management.MemoryUsage;

@Data
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class LiveMemoryDto {
    private MemoryUsage HeapMemoryUsage;
    private MemoryUsage NonHeapMemoryUsage;
}
