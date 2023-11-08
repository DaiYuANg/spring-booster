package org.toolkit.spring.boot.starter.cache.register;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.concurrent.ConcurrentMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.starter.cache.base.CachedAdapter;

@Component
@Slf4j
public class AdapterRegister {

	@Resource
	private ConcurrentMap<String, CachedAdapter<?, ?>> adapters;

	@Resource
	private DefaultListableBeanFactory beanFactory;

	@PostConstruct
	public void init() {
		adapters.forEach((key, value) -> beanFactory.registerSingleton(key, value));
	}
}
