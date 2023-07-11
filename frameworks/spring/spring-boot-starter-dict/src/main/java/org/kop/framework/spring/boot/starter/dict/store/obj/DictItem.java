package org.kop.framework.spring.boot.starter.dict.store.obj;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Builder
@Accessors(chain = true, fluent = true)
public class DictItem {
    private String code;

    private String name;

    private String text;
}
