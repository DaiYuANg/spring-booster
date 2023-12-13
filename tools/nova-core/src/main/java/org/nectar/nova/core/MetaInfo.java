/* (C)2023*/
package org.nectar.nova.core;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
@Builder
public class MetaInfo {
	private String name;

	private String content;
}
