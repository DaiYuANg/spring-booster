/* (C)2023*/
package org.spring.boost.dev.service.adapter;

import com.github.dockerjava.api.command.CreateContainerResponse;
import org.spring.boost.dev.service.core.ContainerService;

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
