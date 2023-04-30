package org.kop.libs.collections

fun <T> merge(vararg x: List<T>): List<T> {
    val result = ArrayList<T>();
    x.forEach { x1 -> result.addAll(x1) }
    return result
}

fun main() {
    val a = ArrayList<Number>(1)
    val b = ArrayList<Number>(2)
    a.add(1)
    a.add(32)
    b.add(3)
    b.add(543252)
    System.err.println(merge(a, b))
}