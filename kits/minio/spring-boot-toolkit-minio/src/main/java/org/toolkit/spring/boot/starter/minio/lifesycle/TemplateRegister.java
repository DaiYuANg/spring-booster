package org.toolkit.spring.boot.starter.minio.lifesycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.starter.minio.functional.MinioTemplate;

@Component
@Slf4j
public class TemplateRegister {

	@Resource
	private DefaultListableBeanFactory beanFactory;

	@Resource
	private Map<String, MinioTemplate> templateMap;

	@PostConstruct
	public void init() {
		templateMap.forEach(beanFactory::registerSingleton);
	}
}
