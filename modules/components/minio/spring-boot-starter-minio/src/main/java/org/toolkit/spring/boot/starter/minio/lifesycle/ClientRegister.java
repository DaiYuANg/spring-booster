package org.toolkit.spring.boot.starter.minio.lifesycle;

import io.minio.MinioClient;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class ClientRegister {

    @Resource
    private DefaultListableBeanFactory beanFactory;

    @Resource
    private Map<String, MinioClient> clientMap;

    @PostConstruct
    public void init(){
        log.atInfo().log("register clients:{}", clientMap);
        clientMap.forEach((key, value) -> beanFactory.registerSingleton(key, value));
    }
}
