package org.kop.framework.spring.starter.kernel.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "async")
@Data
@ToString
public class AsyncWorkerProperties {
    private int MAX_WORKER;

    private int CORE_WORKER;
}
