package org.toolkit.spring.boot.authentication.filter;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.toolkit.spring.boot.authentication.service.IJwtService;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{

    @PostConstruct
    void init(){
        log.atInfo().log("jwt filter init");
    }

    private final IJwtService jwtService;

    @Override
    public void doFilterInternal(
            @NotNull HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull FilterChain filterChain) throws ServletException, IOException {
        val authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        val jwt = authHeader.substring(7);
        val username = jwtService.extractUsername(jwt);
        val authentication = SecurityContextHolder.getContext().getAuthentication();
        System.err.println(username);
        System.err.println(authentication.getDetails());
        filterChain.doFilter(request,response);
    }
}
