package org.toolkit.spring.boot.dev.service.connection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.toolkit.spring.boot.dev.service.adapter.MysqlContainerContainerService;
import org.toolkit.spring.boot.dev.service.core.ContainerService;
import org.toolkit.spring.boot.dev.service.core.DockerContainer;

@Getter
@AllArgsConstructor
public enum SupportServiceStore {
	MYSQL("com.mysql.cj.jdbc.Driver", new MysqlContainerContainerService(DockerContainer.INSTANCE.getClient()));
	//    H2("org.h2.Driver"),
	//
	//    SQLITE("org.sqlite.JDBC"),
	//
	//    POSTGRESQL("org.postgresql.Driver");

	private final String clazz;

	private final ContainerService containerService;
}
