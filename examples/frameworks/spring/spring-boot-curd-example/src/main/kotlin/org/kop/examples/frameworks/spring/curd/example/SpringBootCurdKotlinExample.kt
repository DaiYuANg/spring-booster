package org.kop.examples.frameworks.spring.curd.example

import org.apache.hc.core5.util.Args
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class SpringBootCurdKotlinExample

fun main(args: Array<String>) {
    runApplication<SpringBootCurdKotlinExample>(*args)
}