package com.example.demo_Kotlin.service.implement

import com.example.demo_Kotlin.dto.EmployeeDto
import com.example.demo_Kotlin.dto.PersonDto
import com.example.demo_Kotlin.entity.parameter.Employee
import com.example.demo_Kotlin.entity.security.Person
import com.example.demo_Kotlin.irespository.IBaseRepository
import com.example.demo_Kotlin.irespository.IEmployeeRepository
import com.example.demo_Kotlin.service.`interface`.IEmployeeService
import com.example.demo_Kotlin.utilitis.GenericMapper

import org.springframework.stereotype.Service


@Service
class EmployeeService(
    private val employeeRepository: IEmployeeRepository,
    private val personService: PersonService,
    val mapper: GenericMapper
): ABaseService<Employee, EmployeeDto>(mapper, Employee::class.java, EmployeeDto::class.java), IEmployeeService   {

    override fun getRepository(): IBaseRepository<Employee, Long> {
        return employeeRepository;
    }

//
//    override fun save(dto: EmployeeDto): EmployeeDto {
//        return try {
//            // Eliminar ID si estás creando un nuevo registro
//            val dtoToSave = dto.copy(id = null)
//
//            // Cargar la entidad relacionada (Person)
//            val person = personService.findById(dtoToSave.personDto.id!!)
//                .orElseThrow { Exception("Persona no encontrada con ID ${dtoToSave.personDto.id}") }
//
//            // Convertir DTO a Entity
//            val entity = dtoToSave.toEntity(person)
//
//            // Guardar en la base de datos
//            val savedEntity = getRepository().save(entity)
//
//            // Retornar como DTO
//            savedEntity.toDto()
//
//        } catch (e: Exception) {
//            throw Exception("Error al guardar la entidad: ${e.message}", e)
//        }
//    }
//
//    fun EmployeeDto.toEntity(person: Person): Employee {
//        return Employee(
//            code = this.code,
//            position = this.position,
//            person = person
//        ).apply {
//            id = this@toEntity.id
//            state = this@toEntity.state
//            createdAt = this@toEntity.createdAt
//            updatedAt = this@toEntity.updatedAt
//            deletedAt = this@toEntity.deletedAt
//        }
//    }
//    fun Employee.toDto(): EmployeeDto {
//        return EmployeeDto(
//            id = this.id,
//            code = this.code,
//            position = this.position,
//            state = this.state,
//            createdAt = this.createdAt,
//            updatedAt = this.updatedAt,
//            deletedAt = this.deletedAt,
//            personDto = PersonDto (
//                id = this.person.id,
//                firstName = this.person.firstName,
//                lastName = this.person.lastName,
//                email = this.person.email,
//                phone = this.person.phone,
//                dateOfBirth = this.person.dateOfBirth,
//                gender = this.person.gender,
//                address = this.person.address,
//                typeDocument = this.person.typeDocument,
//                document = this.person.document,
//                ubication = this.person.ubication,
//                active = this.person.state
//            )
//        )
//    }
//









}