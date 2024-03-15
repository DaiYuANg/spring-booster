/* (C)2023*/
package org.spring.boost.cli.dto;

import lombok.Builder;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Builder
public class DatabaseTableColumn {
    private String columnName;
    private String typeName;
    private Integer columnSize;
    private Integer nullable;
}
