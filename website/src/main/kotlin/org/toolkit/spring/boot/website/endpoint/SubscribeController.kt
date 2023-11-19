package org.toolkit.spring.boot.website.endpoint

import org.springframework.scheduling.annotation.Async
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.toolkit.spring.boot.utils.kotlin.annotation.KotlinSlf4j

@RestController
@RequestMapping("/api/subscribe")
@KotlinSlf4j
class SubscribeController {
    @GetMapping("/")
    @Async
    fun emailSubscribe(
        @RequestParam("address") address: String,
    ) {
    }
}
