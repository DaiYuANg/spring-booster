package org.toolkit.spring.boot.website.aop

import cn.hutool.http.useragent.UserAgentParser
import com.google.common.util.concurrent.RateLimiter
import jakarta.annotation.Resource
import jakarta.servlet.http.HttpServletRequest
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.eclipse.collections.impl.map.mutable.ConcurrentHashMap
import org.springframework.stereotype.Component
import org.toolkit.spring.boot.utils.kotlin.annotation.KotlinSlf4j

@Aspect
@Component
@KotlinSlf4j
class RateLimiterAspect {
    private val rateLimiters: ConcurrentHashMap<String, RateLimiter> = ConcurrentHashMap()

    @Resource
    private lateinit var request: HttpServletRequest

    @Around("@annotation(org.toolkit.spring.boot.website.annotation.RateLimiter)")
    fun before(pjp: ProceedingJoinPoint): Any? {
        val ipAddress: String = getClientIp()
        val deviceInfo: String = getDeviceInfo()
        val key = "$ipAddress-$deviceInfo"
        val rateLimiter =
            rateLimiters.computeIfAbsent(
                key,
            ) { k: Any? -> RateLimiter.create(10.0) } // 10 requests per second
        if (!rateLimiter.tryAcquire()) {
            // 返回限流信息或抛出异常
            throw RuntimeException("API rate limit exceeded")
        }

        return pjp.proceed()
    }

    private fun getClientIp(): String {
        // 从 HttpServletRequest 获取客户端 IP 地址的逻辑
        return request.remoteHost + ":" + request.remotePort
    }

    private fun getDeviceInfo(): String {
        return UserAgentParser.parse(request.getHeader("User-Agent")).engine.name
    }
}
