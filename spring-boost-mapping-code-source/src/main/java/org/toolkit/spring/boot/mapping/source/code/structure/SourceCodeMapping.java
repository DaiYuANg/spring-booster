/* (C)2023*/
package org.toolkit.spring.boot.mapping.source.code.structure;

import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.toolkit.spring.boot.mapping.base.structure.Mapping;

@Getter
@ToString
@Builder
public class SourceCodeMapping implements Mapping<String, SourceCodeMappingItem> {

    private String naming;

    private String code;

    private String description;

    private Boolean enable;

    private String type;

    private Set<SourceCodeMappingItem> items;
}
