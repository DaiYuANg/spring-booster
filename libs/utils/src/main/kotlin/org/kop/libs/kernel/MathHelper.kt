package org.kop.libs.kernel

import java.util.concurrent.CompletableFuture

fun random(min: Number, max: Number): Number {
    CompletableFuture.runAsync {
        System.err.println("123")
    }
    return kotlin.random.Random(min.toInt()).nextInt();
}
