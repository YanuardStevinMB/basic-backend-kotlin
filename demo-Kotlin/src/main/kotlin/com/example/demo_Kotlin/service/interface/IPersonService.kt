package com.example.demo_Kotlin.service.`interface`

import com.example.demo_Kotlin.dto.PersonDto
import com.example.demo_Kotlin.entity.security.Person
import com.example.demo_Kotlin.service.implement.ABaseService

interface IPersonService: IBaseService<Person, PersonDto>  {
}