package com.example.aggim.config

import com.example.aggim.interceptor.TokenValidationInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig @Autowired constructor(
    private val tokenValidationInterceptor: TokenValidationInterceptor
) : WebMvcConfigurer {

    override fun addResourceHandlers(
        registry: ResourceHandlerRegistry
    ) {
        registry.addResourceHandler("/images/**") // 이 주소 밑에 **이 아래 이미지 경로와 매핑됩니다.
            .addResourceLocations("file:///C://Project/Strawberry/aggim") // 이 경로에 밑에 yyyyMMdd 폴더 밑에 업로드할 이미지가 들어있어야 합니다.
        // https://blog.jiniworld.me/28 이 블로그 참고해보세요
    }

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(tokenValidationInterceptor)
            .addPathPatterns("/api/**")
    }

}