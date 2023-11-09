package org.toolkit.spring.boot.minio.configurations.register;

import io.minio.MinioClient;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.utils.bean.BeanUtil;

@Component
@Slf4j
public class ClientRegister {

	@Resource
	private Map<String, MinioClient> clientMap;

	@Resource
	private BeanUtil beanUtil;

	@PostConstruct
	public void init() {
		beanUtil.putAllAsSingleton(clientMap);
		log.atInfo().log("register clients:{}", clientMap);
	}
}
