/* (C)2023*/
package org.toolkit.visualvm.web.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Builder
@ToString
@Accessors(chain = true)
public class SystemOverviewDto {
	private String operationSystem;
}
