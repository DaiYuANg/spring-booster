/* (C)2024*/
package org.spring.boost.web.core.resolver;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Objects;

import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;

public class IndexHtmlResolver extends PathResourceResolver {

  private final String index = "index.html";

  @Override
  protected Resource resolveResourceInternal(
    HttpServletRequest request,
    @NotNull String requestPath,
    @NotNull List<? extends Resource> locations,
    @NotNull ResourceResolverChain chain) {
    val defaultResource = super.resolveResourceInternal(request, requestPath, locations, chain);
    return (Objects.isNull(defaultResource))
      ? super.resolveResourceInternal(request, "%s/%s".formatted(requestPath, index), locations, chain)
      : defaultResource;
  }
}
