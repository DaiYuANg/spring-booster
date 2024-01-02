/* (C)2024*/
package org.spring.boost.minio;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BeanNaming {
	ADMIN("Admin"),

	TEMPLATE("Template");

	private final String naming;
}
