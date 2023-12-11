package org.toolkit.spring.boot.minio.configurations.register;

import cn.hutool.extra.spring.SpringUtil;
import io.minio.MinioClient;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ClientRegister {

	@Resource
	private Map<String, MinioClient> clientMap;

	@PostConstruct
	public void init() {
		clientMap.forEach(SpringUtil::registerBean);
		log.atInfo().log("register clients:{}", clientMap);
	}
}
