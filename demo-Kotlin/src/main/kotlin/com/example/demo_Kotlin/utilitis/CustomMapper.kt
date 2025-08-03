package com.example.demo_Kotlin.utilitis

interface CustomMapper<D, E> {
    fun toEntity(dto: D): E
    fun toDto(entity: E): D
}
