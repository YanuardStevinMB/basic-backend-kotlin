package com.example.demo_Kotlin.controller.operational

import com.example.demo_Kotlin.controller.ABaseController
import com.example.demo_Kotlin.dto.ClientDto
import com.example.demo_Kotlin.dto.EmployeeDto
import com.example.demo_Kotlin.entity.parameter.Client
import com.example.demo_Kotlin.entity.parameter.Employee
import com.example.demo_Kotlin.service.implement.ClientService
import com.example.demo_Kotlin.service.`interface`.IClientService
import com.example.demo_Kotlin.service.`interface`.IEmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["*"])
@RestController
@RequestMapping("v1/client")
class ClientController @Autowired constructor(

    private val clientService: IClientService,

    ): ABaseController<Client, ClientDto, IClientService>(clientService,"client"){
}