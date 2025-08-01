package com.sena.servicesecurity.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@MappedSuperclass
abstract class ABaseEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "state", nullable = false)
    var state: Boolean = true,

    @Column(name = "created_at", nullable = true)
    var createdAt: LocalDateTime? = null,

    @Column(name = "updated_at", nullable = true)
    var updatedAt: LocalDateTime? = null,

    @Column(name = "deleted_at", nullable = true)
    var deletedAt: LocalDateTime? = null,

    @Column(name = "created_by", nullable = true)
    var createdBy: Long? = null,

    @Column(name = "updated_by", nullable = true)
    var updatedBy: Long? = null,

    @Column(name = "deleted_by", nullable = true)
    var deletedBy: Long? = null
)
