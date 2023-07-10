package org.kop.framework.spring.boot.starter.groundwork.dict.store;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.kop.framework.spring.boot.starter.groundwork.dict.annotation.DictDefine;
import org.kop.framework.spring.boot.starter.groundwork.dict.exceiptions.DictDefineNotEnumException;
import org.reflections.Reflections;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentSkipListMap;

@Component
@Slf4j
public class DictStore {
    private final ConcurrentSkipListMap<String, List<String>> cache = new ConcurrentSkipListMap<>();

    @EventListener(ContextRefreshedEvent.class)
    @Async
    public void init(@NotNull ContextRefreshedEvent context) {
        log.info("load cache");
        val name = context.getApplicationContext().getBeanNamesForAnnotation(SpringBootApplication.class);
        Arrays.stream(name).forEach(d -> {
            val app = context.getApplicationContext().getBean(d).getClass().getAnnotation(SpringBootApplication.class);
            scanPackages(app.scanBasePackages());
        });
    }

    private void scanPackages(String[] basePackages) {
        val allDefined = Arrays.stream(basePackages).parallel().map(Reflections::new)
                .flatMap(ref -> ref.getTypesAnnotatedWith(DictDefine.class).stream()).toList();
        if (allDefined.stream().noneMatch(Class::isEnum)) throw new DictDefineNotEnumException();
        allDefined.forEach(dict ->
                cache.put(dict.getSimpleName(), Arrays.stream(dict.getEnumConstants())
                        .map(Objects::toString)
                        .toList()));
    }

    public List<String> text(String dict) {
        return cache.get(dict);
    }
}
