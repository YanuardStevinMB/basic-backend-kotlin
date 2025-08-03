package com.example.demo_Kotlin.dto

data class ClientDto(
    var id: Long? = null,
    var code: String = "",
    var person: PersonDto = PersonDto()
)