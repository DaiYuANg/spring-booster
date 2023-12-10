package org.toolkit.spring.boot.mapping.base.structure;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MappedIndex implements Serializable {

	private String packageName;

	private String className;
}
