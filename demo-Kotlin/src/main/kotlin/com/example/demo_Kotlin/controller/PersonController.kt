package com.example.demo_Kotlin.controller

import com.example.demo_Kotlin.dto.PersonDto
import com.example.demo_Kotlin.entity.security.Person
import com.example.demo_Kotlin.service.`interface`.IPersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["*"])
@RestController
@RequestMapping("v1/api/persons")
class PersonController @Autowired constructor(
  private val personService: IPersonService
) : ABaseController<Person, PersonDto, IPersonService>(personService, "person")
