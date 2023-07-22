package com.tqi.challenge.backend.marketplace.configs

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.context.annotation.Configuration

@Configuration
@OpenAPIDefinition(info = Info(title = "JuMarket Application System",
    description = "Self-service buy-sell application", version = "v1")
)
class Swagger3Config {
}