package org.toolkit.spring.boot.mapping.source.code.structure;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.toolkit.spring.boot.mapping.core.structure.Mapping;

import java.util.Set;

@Getter
@ToString
@Builder
public class StaticFieldMapping implements Mapping<String, StaticFieldMappingItem> {

    private String naming;

    private String code;

    private String description;

    private Boolean delete;

    private String type;

    private Set<StaticFieldMappingItem> items;
}
