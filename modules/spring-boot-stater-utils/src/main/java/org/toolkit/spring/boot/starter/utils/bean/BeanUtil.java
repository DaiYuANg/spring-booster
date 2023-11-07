package org.toolkit.spring.boot.starter.utils.bean;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class BeanUtil {
    @Resource
    private ApplicationContext context;

    @Resource
    private DefaultListableBeanFactory beanFactory;

    public <T> List<T> findBeans(Class<T> clazz) {
        return context.getBeansOfType(clazz).values().stream().toList();
    }
}

