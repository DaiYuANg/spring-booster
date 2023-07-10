package org.kop.libs.helpers

import java.util.*
import java.util.stream.Collectors


fun <K, V> keyList(map: Map<K, V>): List<K> {
    return map.keys.toMutableList()
}

fun <K, V> valueList(map: Map<K, V>): List<V> {
    return map.values.toMutableList()
}

fun <K, V> searchValueOptional(map: Map<K, V>, value: V): Optional<V> {
    return valueList(map).stream().filter { obj: V -> value!! == obj }.findFirst()
}

fun <K, V> searchByValueList(map: Map<K, V>, value: V): List<V> {
    return valueList(map).stream().filter { obj: V -> value!! == obj }
        .collect(Collectors.toList())
}
