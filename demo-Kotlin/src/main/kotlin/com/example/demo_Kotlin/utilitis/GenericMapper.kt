package com.example.demo_Kotlin.utilitis

import com.example.demo_Kotlin.dto.ClientDto
import com.example.demo_Kotlin.dto.PersonDto
import com.example.demo_Kotlin.entity.parameter.Client
import com.example.demo_Kotlin.entity.security.Person
import org.modelmapper.Converter
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
