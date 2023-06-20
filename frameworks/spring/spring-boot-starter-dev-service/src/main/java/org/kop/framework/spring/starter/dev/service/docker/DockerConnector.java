package org.kop.framework.spring.starter.dev.service.docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.PullImageResultCallback;
import com.github.dockerjava.api.model.PullResponseItem;
import com.github.dockerjava.api.model.ResponseItem;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import jakarta.annotation.PreDestroy;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;

import java.io.Closeable;
import java.time.Duration;
import java.util.Objects;

@Slf4j
@Component
public class DockerConnector {

    private final DockerClient dockerClient;

    public DockerConnector() {
        val config = DefaultDockerClientConfig.createDefaultConfigBuilder()
                .build();
        val httpClient = new ApacheDockerHttpClient.Builder()
                .dockerHost(config.getDockerHost())
                .sslConfig(config.getSSLConfig())
                .maxConnections(100)
                .connectionTimeout(Duration.ofSeconds(30))
                .responseTimeout(Duration.ofSeconds(45))
                .build();
        dockerClient = DockerClientImpl.getInstance(config, httpClient);
    }

    @SneakyThrows
    public void pull(String image, boolean async) {
        val progressHandler = new ProgressHandler();
        try (val pull = dockerClient.pullImageCmd(image).exec(new PullImageResultCallback() {
            @Override
            public void onNext(PullResponseItem item) {
                progressHandler.handleProgress(item.getProgressDetail());
            }

            @Override
            public void onStart(Closeable stream) {
                log.info("start pull:{}", image);
            }
        })) {
            if (async) pull.awaitCompletion();
        }
    }

    public void pull(String image) {
        pull(image, true);
    }

    public void run() {
//        dockerClient.createContainerCmd("mysql:latest").withport.exec();
    }

    static class ProgressHandler {
        void handleProgress(ResponseItem.ProgressDetail progressDetail) {
            if (Objects.isNull(progressDetail) ||
                    Objects.isNull(progressDetail.getTotal()) ||
                    progressDetail.getTotal() <= 0 ||
                    Objects.isNull(progressDetail.getCurrent())
            ) {
                return;
            }
            int percentage = (int) ((progressDetail.getCurrent() * 100) / progressDetail.getTotal());
            System.err.print("\rProgress: " + percentage + "%");
            System.out.flush();
        }
    }

    @SneakyThrows
    @PreDestroy
    public void shutdownHook() {
        log.info("dev service docker client close");
        dockerClient.close();
    }
}
