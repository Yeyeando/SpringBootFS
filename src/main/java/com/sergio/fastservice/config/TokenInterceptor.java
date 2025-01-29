//package com.sergio.fastservice.config;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//@Component
//public class TokenInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("Interceptor ejecutándose para: " + request.getRequestURI());
//
//        String token = request.getHeader("Authorization");
//
//        if (token == null || !token.equals("Bearer secure-token-123")) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            response.getWriter().write("Unauthorized: Invalid or missing token");
//            return false;
//        }
//
//        return true; // Permite la solicitud si el token es válido
//    }
//}
