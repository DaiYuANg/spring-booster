package org.toolkit.spring.boot.dev.service.adapter;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.PullImageResultCallback;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.PullResponseItem;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import me.tongfei.progressbar.ProgressBar;
import me.tongfei.progressbar.ProgressBarBuilder;
import org.toolkit.spring.boot.dev.service.base.PullImageProcessBar;
import org.toolkit.spring.boot.dev.service.base.ServiceAdapter;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Slf4j
public class MysqlServiceAdapter implements ServiceAdapter {

    private final DockerClient client;

    private final String image = "mysql:latest";

    @SneakyThrows
    public CreateContainerResponse createService() {
        try(val pullCallback = new PullImageProcessBar()){
            val exec = client.pullImageCmd(image)
                    .exec(pullCallback).awaitCompletion();
            val container = client.createContainerCmd(image)
                    .withExposedPorts(ExposedPort.tcp(3306))
                    .withEnv("MYSQL_RANDOM_ROOT_PASSWORD=true")
                    .exec();
            log.info("create container:{}", container.getRawValues());
            return container;
        }
    }
}
