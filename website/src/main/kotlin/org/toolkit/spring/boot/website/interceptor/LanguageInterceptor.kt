package org.toolkit.spring.boot.website.interceptor

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.toolkit.spring.boot.utils.kotlin.annotation.KotlinSlf4j

@KotlinSlf4j
@Component
class LanguageInterceptor : HandlerInterceptor {
    private val staticResourcePrefixes = setOf("/static/", "/public/", "/resources/", "/META-INF/resources/")
    private val supportedLanguages = setOf("en", "zh")

    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
    ): Boolean {
        // 获取请求路径
        val requestPath = request.requestURI
        // 判断请求路径是否为静态资源
//        return when {
//            isStaticResource(requestPath) -> true
//            hasLanguageCode(requestPath) -> true
//            else -> {
//                val clientLocale = request.locale
//                val language = clientLocale.language
//                when (language) {
//                    "en" -> response.sendRedirect("/en")
//                    "zh" -> response.sendRedirect("/zh")
//                }
//                log.info("do redirect:{}", language)
//                false
//            }
//        }
        return true
    }

    private fun isStaticResource(requestPath: String): Boolean {
        return staticResourcePrefixes.any { requestPath.startsWith(it) }
    }

    private fun hasLanguageCode(requestPath: String): Boolean {
        System.err.println(requestPath.startsWith("/zh"))
        return supportedLanguages.any { requestPath.startsWith("/$it/") }
    }
}
