package com.example.demo_Kotlin.irespository

import com.example.demo_Kotlin.dto.EmployeeDto
import com.example.demo_Kotlin.entity.parameter.Employee
import org.springframework.stereotype.Repository

@Repository
interface IEmployeeRepository: IBaseRepository<Employee, Long> {
}