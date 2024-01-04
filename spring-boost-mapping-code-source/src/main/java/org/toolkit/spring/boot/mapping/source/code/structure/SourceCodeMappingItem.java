/* (C)2023*/
package org.toolkit.spring.boot.mapping.source.code.structure;

import lombok.Builder;
import lombok.Getter;
import org.toolkit.spring.boot.mapping.base.structure.MappingItem;

@Getter
@Builder
public class SourceCodeMappingItem implements MappingItem<String> {

    private String value;

    private String text;

    private int sort;
}
