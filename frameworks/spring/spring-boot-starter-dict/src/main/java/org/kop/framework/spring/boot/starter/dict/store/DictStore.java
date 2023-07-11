package org.kop.framework.spring.boot.starter.dict.store;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.kop.libs.helpers.ListHelper;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;

@Slf4j
@Component
public class DictStore {

    private final ConcurrentSkipListMap<String, List<String>> cache = new ConcurrentSkipListMap<>();

    @EventListener(ApplicationStartedEvent.class)
    @Async
    public void init(@NotNull ApplicationStartedEvent context) {
        log.info("load cache");
        val base = context.getSpringApplication().getMainApplicationClass().getAnnotation(SpringBootApplication.class).scanBasePackages();
        val packages = ListHelper.merge(Arrays.stream(base).toList(), Collections.singletonList(context.getSpringApplication().getMainApplicationClass().getPackageName()));
        scanPackages(packages);
//        val name = context.getApplicationContext().getBeanNamesForAnnotation(SpringBootApplication.class);
//        Arrays.stream(name).forEach(d -> doScan(context.getApplicationContext().getBean(d)));
    }

    private void scanPackages(@NotNull List<String> basePackages) {
        val allDefined = basePackages.stream().map(prefix ->
                        new Reflections(new ConfigurationBuilder()
                                .forPackage(prefix)
                                .setParallel(true)
                                .setScanners(Scanners.TypesAnnotated, Scanners.FieldsAnnotated, Scanners.SubTypes)
                                .setExpandSuperTypes(true)
                        ))
                .flatMap(ref -> {
                    return ref.getSubTypesOf(BindDict.class).stream();
//                    return Stream.of(ref.ge(DictDefine.class).stream(),
//                            ref.getTypesAnnotatedWith(DictDefine.class).stream(), ref.getSubTypesOf(Enum.class).stream());
                })
                .filter(Class::isEnum)
                .toList();
        allDefined.forEach(c -> {

        });
//        allDefined.stream().forEach(c->{
//            System.err.println(c.);
//        });
//        allDefined.stream().filter(c -> c.getDeclaredFields().length != 0).forEach(c -> {
//            System.err.println(c);
//        });
//
//        allDefined.stream().filter(c -> c.getDeclaredFields().length == 0).forEach(c -> {
//            System.err.println(c);
//        });
    }

    public List<String> text(String dict) {
        return cache.get(dict);
    }
}
