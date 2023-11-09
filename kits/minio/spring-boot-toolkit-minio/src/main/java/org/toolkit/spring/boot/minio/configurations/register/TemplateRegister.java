package org.toolkit.spring.boot.minio.configurations.register;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.toolkit.spring.boot.minio.core.template.MinioTemplate;
import org.toolkit.spring.boot.utils.bean.BeanUtil;

@AutoConfiguration
@Slf4j
public class TemplateRegister {

	@Resource
	private BeanUtil beanUtil;

	@Resource
	private Map<String, MinioTemplate> templateMap;

	@PostConstruct
	public void init() {
		beanUtil.putAllAsSingleton(templateMap);
		log.atDebug().log("register templates:{}", templateMap);
	}
}
