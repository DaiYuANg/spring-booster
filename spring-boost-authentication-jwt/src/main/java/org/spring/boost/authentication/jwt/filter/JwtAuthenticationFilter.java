/* (C)2023*/
package org.spring.boost.authentication.jwt.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.authentication.feature.bundle.authenticated.AuthenticatedEvent;
import org.spring.boost.authentication.jwt.service.IJwtService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Builder
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final IJwtService jwtService;

    private final UserDetailsService userDetailsService;

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void doFilterInternal(
            @NotNull HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull FilterChain filterChain)
            throws ServletException, IOException {
        val authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        log.atInfo().log("auth header:{}", authHeader);
        val jwt = authHeader.substring(7);
        val username = jwtService.extractUsername(jwt);
        val authentication = SecurityContextHolder.getContext().getAuthentication();
        val userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);
        eventPublisher.publishEvent(new AuthenticatedEvent(this, jwt, userDetails));
        filterChain.doFilter(request, response);
    }
}
