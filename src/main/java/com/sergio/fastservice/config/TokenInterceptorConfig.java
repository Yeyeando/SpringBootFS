//package com.sergio.fastservice.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class TokenInterceptorConfig implements WebMvcConfigurer {
//
//	 	@Autowired
//	    private TokenInterceptor tokenInterceptor;
//
//	    @Override
//	    public void addInterceptors(InterceptorRegistry registry) {
//	        registry.addInterceptor(tokenInterceptor)
//	                .addPathPatterns("/tables/**") // Intercepta solo las rutas protegidas
//	                .excludePathPatterns("/**"); // Permite rutas públicas
//	    }
//	}
