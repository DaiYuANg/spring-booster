/* (C)2023*/
package org.toolkit.example.constant;

import org.toolkit.spring.boot.mapping.source.code.annotation.StaticField;

public final class UserType {

	@StaticField(key = "user_type_internal")
	public static final int INTERNAL = 1;

	@StaticField(key = "user_type_internal")
	public static final int OUTSIDE = 2;
}
