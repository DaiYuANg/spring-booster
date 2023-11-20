package org.toolkit.spring.boot.utils.autoconfigure;

import cn.hutool.extra.spring.EnableSpringUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.toolkit.spring.boot.utils.bean.BeanUtil;

@AutoConfiguration
@Slf4j
@EnableSpringUtil
public class SpringBootUtilAutoConfiguration {
	@Resource
	private ApplicationContext context;

	@Resource
	private DefaultListableBeanFactory factory;

	@Bean
	public BeanUtil beanUtil() {
		return new BeanUtil(context, factory);
	}
}
