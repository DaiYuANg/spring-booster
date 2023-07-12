package org.toolkit4j.framework.spring.starter.monitor.bootstrap;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class StartAnalyser implements BeanPostProcessor,
        ApplicationListener<ContextRefreshedEvent> {
    private final Map<String, Long> beanStartTime = new HashMap<>();
    private static final AtomicBoolean started = new AtomicBoolean(false);

    @Override
    public void onApplicationEvent(@NotNull ContextRefreshedEvent event) {
        if (!started.compareAndSet(false, true)) return;
        beanStartTime.forEach((key, value) -> {
//            if (value > 1) log.warn("slow Spring bean => :{} :{}", key, value);
        });
    }

    @Override
    public Object postProcessAfterInitialization(@NotNull Object bean, @NotNull String beanName) throws BeansException {
        Long begin = beanStartTime.get(beanName);
        if (Objects.nonNull(beanStartTime.get(beanName))) {
            beanStartTime.put(beanName, DateUtil.between(new DateTime(begin), new DateTime(System.currentTimeMillis()), DateUnit.MS));
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(@NotNull Object bean, @NotNull String beanName) throws BeansException {
        beanStartTime.put(beanName, System.currentTimeMillis());
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
