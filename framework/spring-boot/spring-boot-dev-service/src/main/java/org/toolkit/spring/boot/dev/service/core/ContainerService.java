/* (C)2023*/
package org.toolkit.spring.boot.dev.service.core;

import com.github.dockerjava.api.command.CreateContainerResponse;

public interface ContainerService {

	CreateContainerResponse createService();

	String startContainer();
}
