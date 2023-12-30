/* (C)2023*/
package org.toolkit.spring.boot.dev.service.connection;

import com.google.common.collect.ImmutableSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.toolkit.spring.boot.dev.service.adapter.MysqlContainerContainerService;
import org.toolkit.spring.boot.dev.service.core.ContainerService;
import org.toolkit.spring.boot.dev.service.core.DockerContainer;

@Getter
@AllArgsConstructor
public enum SupportServiceStore {
	MYSQL(
			ImmutableSet.of("com.mysql.cj.jdbc.Driver", "com.mysql.jdbc.Driver"),
			new MysqlContainerContainerService(DockerContainer.INSTANCE.getClient()));
	//    H2("org.h2.Driver"),
	//
	//    SQLITE("org.sqlite.JDBC"),
	//
	//    POSTGRESQL("org.postgresql.Driver");

	private final Set<String> clazz;

	private final ContainerService containerService;
}
