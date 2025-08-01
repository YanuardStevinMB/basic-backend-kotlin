package com.example.demo_Kotlin.entity.security

import com.sena.servicesecurity.entity.ABaseEntity
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull

@Entity
@Table(name = "users")
class User(

    @Column(name = "username", nullable = false, unique = true)
    var username: String = "",

    @Column(name = "password", nullable = false)
    var password: String = "",

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "person_id", nullable = false, unique = true)
    var person: Person ,

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_role",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    var role: MutableSet<Role> = HashSet()

) : ABaseEntity()
