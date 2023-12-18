/* (C)2023*/
package org.toolkit.spring.boot.minio.configurations.register;

import io.minio.MinioClient;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ClientRegister {

	@Resource
	private Map<String, MinioClient> clientMap;

	@Resource
	private DefaultListableBeanFactory beanFactory;

	@PostConstruct
	public void init() {
		clientMap.forEach(beanFactory::registerSingleton);
		log.atInfo().log("register clients:{}", clientMap);
	}
}
