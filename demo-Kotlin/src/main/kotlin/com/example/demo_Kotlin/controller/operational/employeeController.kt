package com.example.demo_Kotlin.controller.operational

import com.example.demo_Kotlin.controller.ABaseController
import com.example.demo_Kotlin.dto.EmployeeDto
import com.example.demo_Kotlin.entity.parameter.Employee
import com.example.demo_Kotlin.service.`interface`.IEmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["*"])
@RestController
@RequestMapping("v1/employees")
class employeeController @Autowired constructor(

    private val employeeService: IEmployeeService,

): ABaseController<Employee, EmployeeDto, IEmployeeService>(employeeService,"employee"){
}