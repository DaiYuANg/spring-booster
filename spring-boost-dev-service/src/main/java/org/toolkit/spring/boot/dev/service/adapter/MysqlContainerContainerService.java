/* (C)2023*/
package org.toolkit.spring.boot.dev.service.adapter;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.ExposedPort;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.toolkit.spring.boot.dev.service.core.ContainerService;
import org.toolkit.spring.boot.dev.service.core.PullImageProcessBar;

@RequiredArgsConstructor
@Slf4j
public class MysqlContainerContainerService implements ContainerService {

    private final DockerClient client;

    private final String image = "mysql:latest";

    private String containerId;

    @SneakyThrows
    @Override
    public CreateContainerResponse createService() {
        System.err.println(client);
        val pullCallback = new PullImageProcessBar();
        client.pullImageCmd(image).exec(pullCallback);
        pullCallback.awaitCompletion();
        val container = client.createContainerCmd(image)
                .withExposedPorts(ExposedPort.tcp(3306))
                .withEnv("MYSQL_RANDOM_ROOT_PASSWORD=true")
                .exec();
        log.info("create container:{}", container.getRawValues());
        client.createContainerCmd(image).exec();
        return container;
    }

    @Override
    public String startContainer() {
        client.startContainerCmd(containerId).exec();
        return containerId;
    }
}
