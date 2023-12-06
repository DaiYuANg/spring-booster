package org.toolkit.spring.boot.supervisor.lifecycle;

import io.javalin.Javalin;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class JavaLinLifecycle {

    @Resource
    private Javalin javalin;

    @PostConstruct
    public void init(){
        javalin.start(9999);
    }
}
