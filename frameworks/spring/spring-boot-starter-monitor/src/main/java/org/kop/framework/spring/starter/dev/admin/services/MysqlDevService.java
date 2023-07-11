package org.kop.framework.spring.starter.dev.admin.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.kop.framework.spring.starter.dev.admin.docker.DockerConnector;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MysqlDevService {
    @Resource
    private DockerConnector dockerConnector;

    private static final String defaultMysqlImage = "mysql:latest";

    @SneakyThrows
    @PostConstruct
    public void init() {
        log.info("mysql dev servicce");
//        PullImageResultCallback callback = new PullImageResultCallback();
//        dockerConnector.getDockerClient().pullImageCmd("mariadb")
//                .withTag("latest")
//                .exec(callback);
//
//        // 等待镜像拉取完成
//        callback.awaitCompletion(1, TimeUnit.MINUTES);
//        System.err.println(callback);
//        dockerConnector.pull(defaultMysqlImage);
        // 获取拉取结果
//        PullResponseItem pullResponseItem = callback.awaitCompletion();
//        if (pullResponseItem != null && pullResponseItem.getError() != null) {
//             拉取出错
//            System.out.println("Failed to pull the image: " + pullResponseItem.getError());
//        } else {
//             镜像拉取成功
//            System.out.println("Image pulled successfully");
//        }
    }
}
