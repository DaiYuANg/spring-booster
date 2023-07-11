package org.kop.framework.spring.boot.starter.dict.store;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.kop.framework.spring.boot.starter.dict.annotation.DictMetadata;
import org.kop.framework.spring.boot.starter.dict.annotation.DictValue;
import org.kop.framework.spring.boot.starter.dict.store.obj.Dict;
import org.kop.framework.spring.boot.starter.dict.store.obj.DictItem;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.boot.context.event.ApplicationPreparedEvent;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class DefaultDictScannerImpl implements DictScanner {

    @Override
    public void onApplicationEvent(@NotNull ApplicationPreparedEvent event) {
        System.err.println(123);
//        val context = event.getApplicationContext();
//        val app = Arrays.stream(context.getBeanNamesForAnnotation(SpringBootApplication.class)).toList();
//        cache.putAll(collectDict(scanPackages(
//                                Stream.concat(
//                                        app.stream().flatMap(a -> Arrays.stream(context.getBean(a).getClass().getAnnotation(SpringBootApplication.class).scanBasePackages())),
//                                        app.stream().map(a -> context.getBean(a).getClass().getPackageName()))
//                        )
//                )
//        );
    }

    @Override
    public Stream<Class<?>> scanPackages(@NotNull Stream<String> basePackages) {
        return basePackages.map(prefix ->
                        new Reflections(new ConfigurationBuilder()
                                .forPackage(prefix)
                                .setParallel(true)
                                .setScanners(Scanners.TypesAnnotated, Scanners.FieldsAnnotated, Scanners.SubTypes)
                                .setExpandSuperTypes(true)
                        ))
                .flatMap(ref -> ref.getTypesAnnotatedWith(DictMetadata.class).stream())
                .filter(Class::isEnum)
                .distinct();
    }

    private ConcurrentMap<String, Dict> collectDict(@NotNull Stream<Class<?>> scanned) {
        return scanned.filter(d -> {
                    val metadata = d.getAnnotation(DictMetadata.class);
                    return Objects.nonNull(metadata) && !metadata.code().isBlank();
                })
                .map(this::parseDictAnnotation)
                .collect(Collectors.toConcurrentMap(Dict::getCode, dict -> dict));
    }

    private Dict parseDictAnnotation(@NotNull Class<?> c) {
        val metadata = c.getAnnotation(DictMetadata.class);
        val items = Arrays.stream(c.getFields())
                .map(field -> field.getAnnotation(DictValue.class))
                .filter(Objects::nonNull)
                .filter(v -> StrUtil.isNotBlank(v.code()) || StrUtil.isNotBlank(v.text()))
                .map(v -> DictItem.builder().text(v.text()).code(v.code()).build())
                .collect(Collectors.toConcurrentMap(DictItem::code, dictItem -> dictItem));
        return Dict.builder()
                .description(metadata.desc())
                .items(items)
                .code(metadata.code())
                .build();
    }
}
