package org.nectar.nova.core;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@ToString
@Accessors(chain = true)
@Builder
public class SiteInfo {

    private String siteTitle;

    private List<MetaInfo> metaInfos;
}
