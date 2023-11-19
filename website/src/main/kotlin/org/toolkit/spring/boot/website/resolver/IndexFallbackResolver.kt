package org.toolkit.spring.boot.website.resolver

import jakarta.servlet.http.HttpServletRequest
import org.springframework.core.io.Resource
import org.springframework.web.servlet.resource.PathResourceResolver
import org.springframework.web.servlet.resource.ResourceResolverChain

class IndexFallbackResolver : PathResourceResolver() {
    val index = "index.html"

    override fun resolveResourceInternal(
        request: HttpServletRequest?,
        requestPath: String,
        locations: MutableList<out Resource>,
        chain: ResourceResolverChain,
    ): Resource? {
        return super.resolveResourceInternal(request, requestPath, locations, chain)
            ?: super.resolveResourceInternal(request, "$requestPath/$index", locations, chain)
    }
}
