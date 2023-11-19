package org.toolkit.spring.boot.website

import de.codecentric.boot.admin.server.config.EnableAdminServer
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
@EnableAdminServer
@EnableAsync
@EnableAspectJAutoProxy
class WebsiteApplication

fun main(args: Array<String>) {
    SpringApplication.run(WebsiteApplication::class.java, *args)
}
