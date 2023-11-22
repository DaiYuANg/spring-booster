package org.toolkit.spring.boot.dev.service.adapter;

import com.github.dockerjava.api.command.CreateContainerResponse;
import org.toolkit.spring.boot.dev.service.core.ContainerService;

public class RedisContainerService implements ContainerService {
    @Override
    public CreateContainerResponse createService() {
        return null;
    }

    @Override
    public String startContainer() {
        return null;
    }
}
