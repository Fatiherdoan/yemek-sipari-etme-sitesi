package com.Efxpress.efxpressfatih.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;

public interface WebMvcConfig {

    default void addResourceHandlers(ResourceHandlerRegistry registry) {}

    default void configureViewResolvers(ViewResolverRegistry registry) {}

    default void addCorsMappings(CorsRegistry registry) {}
}
