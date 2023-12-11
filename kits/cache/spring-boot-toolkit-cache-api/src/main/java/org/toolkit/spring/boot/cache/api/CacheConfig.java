package org.toolkit.spring.boot.cache.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.function.Function;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@Builder
public class CacheConfig<K,V> {

    private Function<K, Object> keyConvertor;

    @Builder.Default
    private boolean enableNullValue = false;
}
