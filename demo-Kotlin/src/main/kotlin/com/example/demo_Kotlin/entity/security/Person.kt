package com.example.demo_Kotlin.entity.security

import com.sena.servicesecurity.entity.ABaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
class Person(
    @field:Column(name = "first_name", length = 50, nullable = false)
    open var firstName: String = "",

    @field:Column(name = "last_name", length = 50, nullable = false)
    open var lastName: String = "",

    @field:Column(name = "email", length = 50, nullable = false, unique = true)
    open var email: String = "",

    @field:Column(name = "phone", length = 15, nullable = false)
    open var phone: String = "",

    @field:Column(name = "date_of_birth", nullable = false)
    open var dateOfBirth: LocalDate = LocalDate.now(),

    @field:Column(name = "gender", length = 10, nullable = false)
    open var gender: String = "",

    @field:Column(name = "address", length = 100, nullable = false)
    open var address: String = "",

    @field:Column(name = "type_document", length = 50, nullable = false)
    open var typeDocument: String = "",

    @field:Column(name = "document", length = 10, nullable = false, unique = true)
    open var document: String = "",

    @field:Column(name = "ubication", length = 100, nullable = false, unique = true)
    open var ubication: String = ""
) : ABaseEntity()
