/* (C)2023*/
package org.toolkit.spring.boot.mapping.core.structure;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MappedIndex implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String packageName;

    private String className;
}
