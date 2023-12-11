package org.toolkit.spring.boot.minio.configurations.register;

import cn.hutool.extra.spring.SpringUtil;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.toolkit.spring.boot.minio.template.MinioTemplate;

@AutoConfiguration
@Slf4j
public class TemplateRegister {

	@Resource
	private Map<String, MinioTemplate> templateMap;

	@PostConstruct
	public void init() {
		templateMap.forEach(SpringUtil::registerBean);
		log.atDebug().log("register templates:{}", templateMap);
	}
}
