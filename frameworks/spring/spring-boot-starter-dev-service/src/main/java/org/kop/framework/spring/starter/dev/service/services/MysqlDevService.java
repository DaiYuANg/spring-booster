package org.kop.framework.spring.starter.dev.service.services;

import cn.hutool.core.util.RandomUtil;
import jakarta.annotation.Resource;
import org.kop.framework.spring.starter.dev.service.docker.DockerConnector;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MysqlDevService implements ApplicationRunner {
    @Resource
    private DockerConnector dockerConnector;

    private static final String defaultMysqlImage = "mysql:latest";

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.err.println("run");
    }

    public MysqlDevService() {
        System.err.println(dockerConnector);
//        dockerConnector.pull(defaultMysqlImage);
        RandomUtil.randomInt(50000, 65535);
    }
}
