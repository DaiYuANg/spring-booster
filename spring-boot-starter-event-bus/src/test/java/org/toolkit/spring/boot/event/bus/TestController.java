package org.toolkit.spring.boot.event.bus;

import io.vertx.core.eventbus.EventBus;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Resource
    private EventBus eventBus;

    @GetMapping
    public void index() {
        eventBus.request("test", "dsad")
                .onComplete(event -> {
                    System.err.println(event.result().body());
                });
    }
}
