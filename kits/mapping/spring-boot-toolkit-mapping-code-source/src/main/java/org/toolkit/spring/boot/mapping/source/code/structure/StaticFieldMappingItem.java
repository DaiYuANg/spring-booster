package org.toolkit.spring.boot.mapping.source.code.structure;

import lombok.Builder;
import lombok.Getter;
import org.toolkit.spring.boot.mapping.core.structure.MappingItem;

@Getter
@Builder
public class StaticFieldMappingItem implements MappingItem<String> {

    private String value;

    private String text;

}
