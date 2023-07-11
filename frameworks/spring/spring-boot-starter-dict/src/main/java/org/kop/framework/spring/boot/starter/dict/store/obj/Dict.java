package org.kop.framework.spring.boot.starter.dict.store.obj;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

@Data
@ToString
@Accessors(chain = true)
@Builder
public class Dict {
    String code;

    String description;

    ConcurrentMap<String, DictItem> items;

    public Optional<DictItem> getByCode(String code) {
        return Optional.ofNullable(items.get(code));
    }
}
