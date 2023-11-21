package org.toolkit.spring.boot.website.interceptor

import jakarta.annotation.Resource
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.toolkit.spring.boot.utils.kotlin.annotation.KotlinSlf4j
import org.toolkit.spring.boot.website.entity.AccessEntity
import org.toolkit.spring.boot.website.repository.AccessEntityRepository
import java.lang.Exception

@Component
@KotlinSlf4j
class AccessInterceptor : HandlerInterceptor {
    @Resource
    private lateinit var accessEntityRepository: AccessEntityRepository

    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?,
    ) {
        if (ex != null) return
        val userAnent = request.getHeader("User-Agent")
        val ipAddress = request.remoteHost
        val port = request.remotePort
        val entity = AccessEntity(userAnent, ipAddress, port)
        accessEntityRepository.save(entity)
    }
}
