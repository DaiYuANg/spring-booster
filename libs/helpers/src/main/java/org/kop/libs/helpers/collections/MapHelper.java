package org.kop.libs.helpers.collections;

import jdk.jfr.Experimental;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@UtilityClass
@Slf4j
@Experimental
public final class MapHelper {
    public <K, V> List<K> keyList(@NotNull Map<K, V> map) {
        return map.keySet().stream().toList();
    }

    public <K, V> List<V> valueList(@NotNull Map<K, V> map) {
        return map.values().stream().toList();
    }

    public <K, V> @NotNull Optional<V> searchValueOptional(Map<K, V> map, @NotNull V value) {
        return valueList(map).stream().filter(value::equals).findFirst();
    }

    public <K, V> @NotNull List<V> searchByValueList(Map<K, V> map, @NotNull V value) {
        return valueList(map).stream().filter(value::equals).collect(Collectors.toList());
    }
}
