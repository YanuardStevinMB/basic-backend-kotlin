package com.example.demo_Kotlin.irespository

import com.example.demo_Kotlin.entity.security.Person
import org.springframework.stereotype.Repository

@Repository
interface IPersonRepository: IBaseRepository<Person, Long> {
}