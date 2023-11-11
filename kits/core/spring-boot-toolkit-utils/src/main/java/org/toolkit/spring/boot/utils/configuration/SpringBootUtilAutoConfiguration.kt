package org.toolkit.spring.boot.utils.configuration

import cn.hutool.extra.spring.EnableSpringUtil
import jakarta.annotation.Resource
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.support.DefaultListableBeanFactory
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.toolkit.spring.boot.utils.bean.BeanUtil

@AutoConfiguration
@Slf4j
@EnableSpringUtil
class SpringBootUtilAutoConfiguration {
    @Resource
    private lateinit var context: ApplicationContext

    @Resource
    private lateinit var factory: DefaultListableBeanFactory;

    @Bean
    fun beanUtil(): BeanUtil {
        return BeanUtil(context, factory)
    }
}
