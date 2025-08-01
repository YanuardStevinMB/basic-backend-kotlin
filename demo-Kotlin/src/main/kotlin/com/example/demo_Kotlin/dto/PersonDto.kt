package com.example.demo_Kotlin.dto

import java.time.LocalDate

data class PersonDto(
    var id: Long? = null,
    var firstName: String = "",
    var lastName: String = "",
    var email: String = "",
    var phone: String = "",
    var dateOfBirth: LocalDate? = null,
    var gender: String = "",
    var address: String = "",
    var typeDocument: String = "",
    var document: String = "",
    var ubication: String = "",
    var createAt: LocalDate? = null,
    var updateAt: LocalDate? = null,
    var active: Boolean = true
)
