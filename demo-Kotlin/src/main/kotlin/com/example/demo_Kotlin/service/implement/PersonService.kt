package com.example.demo_Kotlin.service.implement

import com.example.demo_Kotlin.dto.PersonDto
import com.example.demo_Kotlin.entity.security.Person
import com.example.demo_Kotlin.irespository.IBaseRepository
import com.example.demo_Kotlin.irespository.IPersonRepository
import com.example.demo_Kotlin.service.`interface`.IPersonService
import com.example.demo_Kotlin.utilitis.GenericMapper
import org.springframework.stereotype.Service

@Service
class PersonService(
    private val personRepository: IPersonRepository,
    mapper: GenericMapper
) : ABaseService<Person, PersonDto>(mapper, Person::class.java, PersonDto::class.java), IPersonService {

    override fun getRepository(): IBaseRepository<Person, Long> {
        return personRepository
    }
}
