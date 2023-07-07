package org.kop.framework.spring.boot.starter.groundwork.dict.services.impl;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.benmanes.caffeine.cache.Cache;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.kop.framework.spring.boot.starter.async.base.AsyncWorker;
import org.kop.framework.spring.boot.starter.groundwork.dict.annotation.DictTranslate;
import org.kop.framework.spring.boot.starter.groundwork.dict.configuration.DictConfigurationProperties;
import org.kop.framework.spring.boot.starter.groundwork.dict.repos.DictRepository;
import org.kop.framework.spring.boot.starter.groundwork.dict.services.IDictService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Predicate;

@Service
public class DictServiceImpl implements IDictService {
    @Resource
    private DictRepository dictRepository;

    @Resource
    private Cache<String, Optional<String>> cache;

    @Resource
    private DictConfigurationProperties dictConfigurationProperties;

    @Resource
    private EntityManager entityManager;

    @Resource
    private AsyncWorker asyncWorker;

    private final static ObjectMapper objectMapper = new ObjectMapper();

    private final static Predicate<Field> fieldPredicate = f -> f.isAnnotationPresent(DictTranslate.class);

    private final static Predicate<Field> otherTables = f -> {
        val dt = f.getAnnotation(DictTranslate.class);
        return StrUtil.isNotBlank(dt.table()) && StrUtil.isNotBlank(dt.field());
    };

    @Override
    public Map<String, Object> translate(@NotNull Object object) {
        val result = objectMapper.convertValue(object, new TypeReference<Map<String, Object>>() {
        });
        val needTranslates = Arrays.stream(object.getClass().getDeclaredFields())
                .filter(fieldPredicate)
                .toList();
        val others = needTranslates.stream().filter(otherTables).toList();
        asyncWorker.parallelALL(
                () -> doDictTranslate(result, needTranslates),
                () -> doOthersTables(result, others)
        ).join();
        return result;
    }

    private void doDictTranslate(Map<String, Object> result, @NotNull List<Field> fields) {
        fields.forEach(field -> {
            val translatedName = field.getName() + dictConfigurationProperties.getDictPreSuffix();
            String code = field.getAnnotation(DictTranslate.class).code();
            val text = Objects.requireNonNull(cache.getIfPresent(code))
                    .orElseGet(() -> {
                        val d = dictRepository.findByDictCodeIgnoreCase(code).orElseThrow();
                        cache.put(code, Optional.of(d.getDictName()));
                        return d.getDictName();
                    });
            result.put(translatedName, text);
        });
    }

    private void doOthersTables(Map<String, Object> result, @NotNull List<Field> fields) {
        fields.forEach(field -> {
            val textField = field.getAnnotation(DictTranslate.class).field();
//            cache.getIfPresent(textField).orElseGet(()->{
//                String sql = MessageFormat.format("select {0} from{1} where {2}=?code", textField, field.getAnnotation(DictTranslate.class).table(), textField);
//                val q = entityManager.createNativeQuery(sql);
//                q.setParameter("code", field.getAnnotation(DictTranslate.class).code());
//
//            })
        });
    }
}
