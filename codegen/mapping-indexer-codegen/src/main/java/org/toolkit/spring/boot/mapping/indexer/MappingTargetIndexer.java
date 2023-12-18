/* (C)2023*/
package org.toolkit.spring.boot.mapping.indexer;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class MappingTargetIndexer {
	private String className;
	private String methodName;
	private String returnType;
}
