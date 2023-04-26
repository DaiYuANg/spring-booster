package org.daiyuang.framework.spring.async;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "async")
@Data
@ToString
public class AsyncWorkerConfiguration {
    private int MAX_WORKER;

    private int CORE_WORKER;
}
