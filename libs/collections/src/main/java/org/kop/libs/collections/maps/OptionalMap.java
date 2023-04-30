package org.kop.libs.collections.maps;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public class OptionalMap<K, V> extends HashMap<K, V>{
    public Optional<V> optionalGet(V key) {
        return super.values().stream().filter(v -> Objects.equals(v, key)).findAny();
    }
}
