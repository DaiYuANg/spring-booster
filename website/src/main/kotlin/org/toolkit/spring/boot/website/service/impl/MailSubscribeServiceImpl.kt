package org.toolkit.spring.boot.website.service.impl

import org.springframework.stereotype.Service
import org.toolkit.spring.boot.utils.kotlin.annotation.KotlinSlf4j
import log
import org.toolkit.spring.boot.website.service.ISubscribeService

@Service
@KotlinSlf4j
class MailSubscribeServiceImpl : ISubscribeService {
    //    @Resource
//    private lateinit var javaMailSender: JavaMailSender

    override fun subscribe(address: String) {
        log.atInfo().log("subscribe:{}", address)
    }
}
