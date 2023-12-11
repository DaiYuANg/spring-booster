package org.toolkit.spring.boot.dev.service.core;

import com.github.dockerjava.api.command.CreateContainerResponse;
import lombok.SneakyThrows;

public interface ContainerService {

	@SneakyThrows
	CreateContainerResponse createService();

	String startContainer();
}
