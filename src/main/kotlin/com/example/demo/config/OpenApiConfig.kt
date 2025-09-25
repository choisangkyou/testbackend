package com.example.demo.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class OpenApiConfig {  // <- open 추가
    @Bean
    open fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Test Backend API")
                    .version("1.0")
                    .description("DevOps 프로젝트 테스트용 API 문서")
            )
    }
}
