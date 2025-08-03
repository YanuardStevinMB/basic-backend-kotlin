package com.example.demo_Kotlin.config

import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ModelMapperConfig {

    @Bean
    fun modelMapper(): ModelMapper {
        val mapper = ModelMapper()

        // Habilita el mapeo de campos privados y mutabilidad
        mapper.configuration
            .setFieldMatchingEnabled(true)
            .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)

        return mapper
    }
}