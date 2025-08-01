package com.example.demo_Kotlin.service.`interface`

import com.example.demo_Kotlin.dto.EmployeeDto
import com.example.demo_Kotlin.entity.parameter.Employee

interface IEmployeeService : IBaseService<Employee, EmployeeDto> {
}