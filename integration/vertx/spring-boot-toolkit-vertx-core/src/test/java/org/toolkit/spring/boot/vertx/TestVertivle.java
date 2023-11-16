package org.toolkit.spring.boot.vertx;

import io.vertx.core.AbstractVerticle;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestVertivle  extends AbstractVerticle {
    @Override
    public void start() {
        log.info("test");
    }
}
