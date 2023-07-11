package org.kop.framework.spring.boot.starter.dict.store;

import org.jetbrains.annotations.NotNull;
import org.kop.framework.spring.boot.starter.dict.store.obj.Dict;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Stream;

public interface DictScanner extends ApplicationListener<ApplicationPreparedEvent> {
    ConcurrentSkipListMap<String, Dict> cache = new ConcurrentSkipListMap<>();

    @Override
    void onApplicationEvent(@NotNull ApplicationPreparedEvent event);

    Stream<Class<?>> scanPackages(Stream<String> packages);
}
