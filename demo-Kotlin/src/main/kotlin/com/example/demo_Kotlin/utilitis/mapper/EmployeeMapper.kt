import com.example.demo_Kotlin.dto.EmployeeDto
import com.example.demo_Kotlin.entity.parameter.Employee
import com.example.demo_Kotlin.entity.security.Person
import com.example.demo_Kotlin.service.implement.PersonService
import org.modelmapper.ModelMapper
import org.modelmapper.PropertyMap
import org.springframework.stereotype.Component

@Component
class EmployeeMapper(private val personService: PersonService) {

    private val modelMapper = ModelMapper()

    init {
        modelMapper.addMappings(object : PropertyMap<EmployeeDto, Employee>() {
            override fun configure() {
                map().code = source.code
                map().position = source.position
                using { ctx ->
                    val personId = ctx.source as Long
                    personService.findById(personId)
                }.map(source.personId, destination.person)
            }
        })
    }

    fun toEntity(dto: EmployeeDto): Employee {
        return modelMapper.map(dto, Employee::class.java)
    }

    fun toDto(employee: Employee): EmployeeDto {
        return EmployeeDto(
            code = employee.code,
            position = employee.position,
            personId = employee.person.id!!
        )
    }
}
