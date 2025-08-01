package com.example.demo_Kotlin.controller

import com.example.demo_Kotlin.dto.ApiResponseDto
import com.example.demo_Kotlin.dto.IUserDto
import com.example.demo_Kotlin.dto.UserLoginDto
import com.example.demo_Kotlin.entity.security.User
import com.example.demo_Kotlin.service.`interface`.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@CrossOrigin(origins = ["*"])
@RestController
@RequestMapping("v1/api/user")
class UserController @Autowired constructor(
    private val userService: IUserService
) : ABaseController<User, UserLoginDto, IUserService>(userService, "users") {

    @PostMapping("/login")
    fun login(@RequestBody loginData: UserLoginDto): ResponseEntity<ApiResponseDto<IUserDto>> {
        return try {
            val (username, password) = loginData

            val user = userService.getUserWithViews(username, password).orElse(null)

            if (user != null) {
                ResponseEntity.ok(ApiResponseDto("✅ Registro encontrado", user, true))
            } else {
                ResponseEntity.status(404).body(ApiResponseDto("⚠️ Usuario no encontrado", null, false))
            }
        } catch (e: Exception) {
            ResponseEntity.internalServerError().body(
                ApiResponseDto("❌ Error inesperado: ${e.localizedMessage}", null, false)
            )
        }
    }


}
