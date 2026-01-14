package com.yangpixi.rememberdrinkingbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author yangpixi
 * @date 2026/1/14 10:35
 * @description 本地资源映射，便于开发测试，实际生产环境请使用nginx反代
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/avatar/**")
                .addResourceLocations("file:./uploads/avatar/");
    }

}
