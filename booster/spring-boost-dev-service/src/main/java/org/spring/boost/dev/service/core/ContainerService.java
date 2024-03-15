/* (C)2023*/
package org.spring.boost.dev.service.core;

import com.github.dockerjava.api.command.CreateContainerResponse;

public interface ContainerService {

    CreateContainerResponse createService();

    String startContainer();
}
