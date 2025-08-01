package com.example.demo_Kotlin.utilitis


import org.modelmapper.ModelMapper
import org.springframework.stereotype.Component

@Component
class GenericMapper(private val modelMapper: ModelMapper) {

    fun <D, T> mapToEntity(dto: D, entityClass: Class<T>): T {
        return modelMapper.map(dto, entityClass)
    }

    fun <D, T> mapToDto(entity: T, dtoClass: Class<D>): D {
        return modelMapper.map(entity, dtoClass)
    }
}