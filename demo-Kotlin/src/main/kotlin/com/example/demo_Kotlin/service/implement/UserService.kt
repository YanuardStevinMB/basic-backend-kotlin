package com.example.demo_Kotlin.service.implement

import com.example.demo_Kotlin.dto.IUserDto
import com.example.demo_Kotlin.dto.PersonDto
import com.example.demo_Kotlin.dto.UserLoginDto
import com.example.demo_Kotlin.entity.security.Person
import com.example.demo_Kotlin.entity.security.User
import com.example.demo_Kotlin.irespository.IBaseRepository
import com.example.demo_Kotlin.irespository.IUserRepository
import com.example.demo_Kotlin.service.`interface`.IUserService
import com.example.demo_Kotlin.utilitis.GenericMapper
import org.springframework.stereotype.Service
import java.util.Optional


@Service
class UserService(
    private val userRepository: IUserRepository,
    mapper: GenericMapper
) : ABaseService<User, UserLoginDto >(mapper, User::class.java, UserLoginDto::class.java), IUserService {

    override fun getRepository(): IBaseRepository<User, Long> {
        return userRepository
    }

    override fun getUserWithViews(
        username: String,
        password: String
    ): Optional<IUserDto> {
        TODO("Not yet implemented")
    }


}