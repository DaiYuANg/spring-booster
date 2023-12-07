package org.toolkit.spring.boot.website

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling
import org.toolkit.spring.boot.utils.kotlin.annotation.KotlinSlf4j

@SpringBootApplication
@EnableScheduling
@EnableAsync
@EnableAspectJAutoProxy
@KotlinSlf4j
class WebsiteApplication

fun main(args: Array<String>) {
    SpringApplication.run(WebsiteApplication::class.java, *args)
}
