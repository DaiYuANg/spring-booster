package org.toolkit.spring.boot.mapping.core.structure;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class MappedIndex implements Serializable {

    private String packageName;

    private String className;

}
