/* (C)2024*/
package org.spring.boost.minio.factory;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BeanNaming {
	CREATE_TEMPLATE("CreateTemplate"),

	GET_TEMPLATE("GetTemplate"),

	ADMIN("Admin");

	private final String naming;
}
