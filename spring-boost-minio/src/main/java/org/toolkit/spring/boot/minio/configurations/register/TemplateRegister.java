/* (C)2023*/
package org.toolkit.spring.boot.minio.configurations.register;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.toolkit.minio.MinioTemplate;

@AutoConfiguration
@Slf4j
public class TemplateRegister {

	@Resource
	private Map<String, MinioTemplate> templateMap;

	@Resource
	private DefaultListableBeanFactory beanFactory;

	@PostConstruct
	public void init() {
		templateMap.forEach(beanFactory::registerSingleton);
		log.atDebug().log("register templates:{}", templateMap);
	}
}
