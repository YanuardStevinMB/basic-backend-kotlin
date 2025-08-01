package com.example.demo_Kotlin.service.implement

import com.example.demo_Kotlin.dto.EmployeeDto
import com.example.demo_Kotlin.entity.parameter.Employee
import com.example.demo_Kotlin.entity.security.Person
import com.example.demo_Kotlin.irespository.IBaseRepository
import com.example.demo_Kotlin.irespository.IEmployeeRepository
import com.example.demo_Kotlin.service.`interface`.IEmployeeService
import com.example.demo_Kotlin.utilitis.GenericMapper
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class EmployeeService(
    private val employeeRepository: IEmployeeRepository,
    private val personService: PersonService,
    val mapper: GenericMapper
): ABaseService<Employee, EmployeeDto>(mapper, Employee::class.java, EmployeeDto::class.java), IEmployeeService   {

    override fun getRepository(): IBaseRepository<Employee, Long> {
        return employeeRepository;
    }


    override fun save(dto: EmployeeDto): EmployeeDto {
        return try {
            // Asegúrate de que no tenga ID si estás creando uno nuevo
            dto.id = null

            // Mapear DTO a entidad
            val entity = mapper.mapToEntity(dto, Employee::class.java).apply {
                createdAt = LocalDateTime.now()
                createdBy = 1L

                // Asociar persona existente
                val personId = dto.personId ?: throw IllegalArgumentException("El ID de la persona no puede ser null")
                person = personService.findById(personId)
                    .orElseThrow { Exception("Persona no encontrada con ID: $personId") }
            }

            // Guardar en DB
            val savedEntity = getRepository().save(entity)


            // Mapear manualmente el resultado a DTO (sin relaciones complejas)
            EmployeeDto(
                id = savedEntity.id,
                code = savedEntity.code,
                state = savedEntity.state,
                position = savedEntity.position,
                createdAt = savedEntity.createdAt,
                updatedAt = savedEntity.updatedAt,
                deletedAt = savedEntity.deletedAt,
                personId = savedEntity.person.id!!
            )

        } catch (e: Exception) {
            throw Exception("Error al guardar la entidad: ${e.message}", e)
        }
    }







}