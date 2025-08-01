package com.example.demo_Kotlin.dto

interface IUserDto : IGenericDto {

    val username: String?
    val personName: String?
    val personEmail: String?
    val roleId: Long?

}