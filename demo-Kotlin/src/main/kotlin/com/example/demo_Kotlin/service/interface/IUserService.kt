package com.example.demo_Kotlin.service.`interface`

import com.example.demo_Kotlin.dto.IUserDto
import com.example.demo_Kotlin.dto.UserLoginDto
import com.example.demo_Kotlin.entity.security.User
import java.util.Optional


interface IUserService : IBaseService<User, UserLoginDto> {

    /**
     * Obtiene el usuario con sus vistas (permisos, roles, etc.) según usuario y contraseña.
     * @param username nombre de usuario.
     * @param password contraseña del usuario.
     * @return Optional con IUserDto si existe.
     */
    fun getUserWithViews(username: String, password: String): Optional<IUserDto>
}