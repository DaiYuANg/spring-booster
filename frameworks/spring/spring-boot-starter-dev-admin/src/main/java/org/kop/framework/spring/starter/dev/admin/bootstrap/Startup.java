package org.kop.framework.spring.starter.dev.admin.bootstrap;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ThreadPoolExecutor;

@Component
@Slf4j
public class Startup {

    private static final String REQUEST_BEAN_NAME = "requestMappingHandlerMapping";


    @EventListener(ContextRefreshedEvent.class)
    @Async
    public void onRefresh(@NotNull ContextRefreshedEvent event) {
        val context = event.getApplicationContext();
        val tp = context.getBeanNamesForType(ThreadPoolExecutor.class);
        Arrays.stream(tp).forEach(b -> {
            var t = (ThreadPoolExecutor) context.getBean(b);
            log.info(t.toString());
        });

        if (!context.containsBean(REQUEST_BEAN_NAME)) {
            return;
        }
        RequestMappingHandlerMapping requestMapping =
                context.getBean(REQUEST_BEAN_NAME, RequestMappingHandlerMapping.class);
        requestMapping.getHandlerMethods().keySet().stream()
                .map(RequestMappingInfo::getPatternValues)
                .flatMap(Collection::stream)
                .forEach(log::info);

        log.info("context refresh");
    }

    @EventListener(ApplicationStartup.class)
    @Async
    public void onStartup(ApplicationStartup event) {
        log.info("application startup");
    }

    @SneakyThrows
    @EventListener(ApplicationStartedEvent.class)
    @Async
    public void onStarted(@NotNull ApplicationStartedEvent event) {
        log.info("application started");
        val context = event.getApplicationContext();
        val env = context.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port", String.valueOf(8080));
        String path = env.getProperty("server.context-path","/");
        log.info("{}:Start up",context.getDisplayName());
        log.info("Access at: http://{}:{}{}",ip,port,path);
//        new ProcBuilder("open")
//                .withArg("http://localhost:8080/dev/admin/index")
//                .run();
    }
}
