package org.daiyuang.kernel

fun random(min: Number, max: Number): Number {
    return kotlin.random.Random(min.toInt()).nextInt();
}

fun main() {
    println(random(1, 5))
}