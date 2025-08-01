package com.example.demo_Kotlin.entity.security

import com.sena.servicesecurity.entity.ABaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table


@Entity
@Table(name = "role")
class Role(

    @Column(name = "name", nullable = false, unique = true)
    var name: String,

    @Column(name = "description", nullable = false)
    var description: String,


    ) : ABaseEntity()