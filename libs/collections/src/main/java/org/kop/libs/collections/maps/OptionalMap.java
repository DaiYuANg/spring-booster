package org.kop.libs.collections.maps;

import org.kop.libs.collections.defintion.OptionalCollections;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public class OptionalMap<K, V> extends HashMap<K, V> implements OptionalCollections<V> {
    @Override
    public Optional<V> optionalGet(V key) {
        return super.values().stream().filter(v -> Objects.equals(v, key)).findAny();
    }
}
