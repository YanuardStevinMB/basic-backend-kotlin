package com.example.demo_Kotlin.dto


/**
 * Representa una respuesta genérica de API.
 * @param T Tipo de dato contenido en la respuesta.
 */
data class ApiResponseDto<T>(
    val message: String? = null,
    val data: T? = null,
    val status: Boolean? = null
)