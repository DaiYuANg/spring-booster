/* (C)2023*/
package org.nectar.cli.dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class MysqlTableColumn {

	private String COLUMN_NAME;

	private String TYPE_NAME;

	private Integer COLUMN_SIZE;

	private Integer NULLABLE;
}
