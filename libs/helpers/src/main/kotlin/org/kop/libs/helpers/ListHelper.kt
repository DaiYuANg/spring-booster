package org.kop.libs.helpers

import java.util.*
import java.util.function.Function
import java.util.stream.Collectors
import kotlin.math.min

fun <T, K> grouping(l: List<T>, classifier: Function<in T, out K>?): Map<K, List<T>>? {
    return if (l.isEmpty()) HashMap() else l.stream().collect(Collectors.groupingBy(classifier))
}

fun <T : Any> searchEq(source: List<T>, target: T): Optional<T> {
    return if (!source.contains(target)) Optional.empty() else source.stream()
        .filter { s: T -> Objects.nonNull(s) }
        .filter { s: T -> s == target }
        .findAny()
}

fun <T : Any> searchEqNullAble(source: List<T?>, target: T): T? {
//    return source?.let { it.let { it1 -> searchEq(it1, target).orElse(null) } }
    return null
}

fun <T> intersection(list1: List<T>, list2: List<T>): List<T> {
    return list1.stream().filter { o: T -> list2.contains(o) }.distinct().collect(Collectors.toList())
}

fun <T : CharSequence?> listToString(list: List<T>?, separator: CharSequence?): String {
    return java.lang.String.join(separator, list)
}

fun <T> pageList(list: List<T>, pageNo: Int, pageSize: Int): List<T> {
    val start = (pageNo - 1) * pageSize
    val end = pageNo * pageSize
    return list.subList(start, min(end, list.size))
}
