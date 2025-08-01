package com.example.demo_Kotlin.dto

import java.time.LocalDateTime

data class EmployeeDto (
    var id: Long? = 0,
    var code: String = "",
    var state: Boolean = false,
    var position : String = "",
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null,
    var deletedAt: LocalDateTime? = null,
    var personId: Long,

)