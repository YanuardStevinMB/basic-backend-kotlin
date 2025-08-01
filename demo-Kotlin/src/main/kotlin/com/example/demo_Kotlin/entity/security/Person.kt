package com.example.demo_Kotlin.entity.security

import com.sena.servicesecurity.entity.ABaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "person")
class Person(

    @Column(name = "first_name", length = 50, nullable = false)
    var firstName: String,

    @Column(name = "last_name", length = 50, nullable = false)
    var lastName: String,

    @Column(name = "email", length = 50, nullable = false, unique = true)
    var email: String,

    @Column(name = "phone", length = 15, nullable = false)
    var phone: String,

    @Column(name = "date_of_birth", nullable = false)
    var dateOfBirth: LocalDate,

    @Column(name = "gender", length = 10, nullable = false)
    var gender: String,

    @Column(name = "address", length = 100, nullable = false)
    var address: String,

    @Column(name = "type_document", length = 50, nullable = false)
    var typeDocument: String,

    @Column(name = "document", length = 10, nullable = false, unique = true)
    var document: String,

    @Column(name = "ubication", length = 100, nullable = false, unique = true)
    var ubication: String

) : ABaseEntity()
