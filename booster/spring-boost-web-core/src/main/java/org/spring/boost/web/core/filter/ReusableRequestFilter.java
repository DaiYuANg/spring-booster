/* (C)2024*/
package org.spring.boost.web.core.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.MediaType;
import org.springframework.web.util.ContentCachingRequestWrapper;

@Slf4j
public class ReusableRequestFilter implements Filter {

    @Override
    public void doFilter(
            @NotNull ServletRequest servletRequest, ServletResponse servletResponse, @NotNull FilterChain filterChain)
            throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest httpServletRequest) {
            val requestWrapper = new ContentCachingRequestWrapper(httpServletRequest);
            val contentType = servletRequest.getContentType();
            if (contentType != null && contentType.contains(MediaType.MULTIPART_FORM_DATA_VALUE)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                filterChain.doFilter(requestWrapper, servletResponse);
            }
        }
    }
}
