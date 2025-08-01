package com.example.demo_Kotlin.entity.parameter

import com.example.demo_Kotlin.entity.security.Person
import com.sena.servicesecurity.entity.ABaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "employee")
class Employee (
    @Column(name="code", nullable = false,unique = true)
    var  code : String = "",
    @Column(name="position", nullable = false)
    var position : String = "",
    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName =  "id")
    var  person : Person,
): ABaseEntity();