/* (C)2024*/
package org.spring.boost.minio.actuator;

import com.google.common.collect.ImmutableMap;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Singular;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.minio.service.MinioTemplate;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;

@Endpoint(id = "minio")
@RequiredArgsConstructor
@Slf4j
@Builder
public class MinioEndpoint {

    @Singular
    private final ImmutableMap<String, MinioTemplate> templates;

    @ReadOperation
    public String read() {
        return null;
    }

    @ReadOperation
    public String read(@Selector String key) {
        return null;
    }
}
