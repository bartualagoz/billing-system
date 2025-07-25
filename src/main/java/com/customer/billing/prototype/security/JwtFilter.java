package com.customer.billing.prototype.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        System.out.println("➡ Incoming request to: " + path);
        System.out.println("🚧 Skipping JwtFilter for ALL requests (temporary debug mode)");

        // Skip all filtering logic for now (debug mode)
        filterChain.doFilter(request, response);
    }
}
