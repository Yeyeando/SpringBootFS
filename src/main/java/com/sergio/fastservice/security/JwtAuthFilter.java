package com.sergio.fastservice.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

public class JwtAuthFilter extends OncePerRequestFilter { // CORRECCIÓN: Extender OncePerRequestFilter

    private static final String STATIC_TOKEN = "secure-token-123"; // Token fijo para pruebas

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing or invalid token");
            return;
        }

        String token = authHeader.substring(7); // Extrae el token después de "Bearer "

        if (!STATIC_TOKEN.equals(token)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
            return;
        }

        // Simular autenticación exitosa
        Authentication auth = new UsernamePasswordAuthenticationToken("user", null, Collections.emptyList());
        SecurityContextHolder.getContext().setAuthentication(auth);

        chain.doFilter(request, response); // Continuar con la solicitud
    }
}
