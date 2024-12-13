/* (C)2024*/
package org.spring.boost.minio.interceptor;

import io.minio.ObjectWriteResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.minio.event.ObjectCreateEvent;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
@Slf4j
public class EventMinioInterceptor implements MinioInterceptor {
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void afterCreateSuccess(ObjectWriteResponse response) {
        eventPublisher.publishEvent(new ObjectCreateEvent(this, response));
    }
}
