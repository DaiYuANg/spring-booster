/* (C)2023*/
package org.nectar.nova.core;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
@Builder
public class SiteInfo {

	private String siteTitle;

	private List<MetaInfo> metaInfos;
}
