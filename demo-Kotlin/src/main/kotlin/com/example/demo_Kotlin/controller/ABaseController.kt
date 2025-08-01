package com.example.demo_Kotlin.controller

import com.example.demo_Kotlin.dto.ApiResponseDto
import com.example.demo_Kotlin.service.`interface`.IBaseService
import com.sena.servicesecurity.entity.ABaseEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody


/**
 * Abstract base controller providing common CRUD endpoints for entities.
 * @param T The type of entity extending ABaseEntity.
 * @param S The type of service implementing IBaseService for the entity.
 */abstract class ABaseController<T : ABaseEntity, D, S : IBaseService<T, D>>(
    protected val service: S,
    protected val entityName: String
) {

    @GetMapping
    fun findByStateTrue(): ResponseEntity<ApiResponseDto<List<T>>> {
        return try {
            ResponseEntity.ok(ApiResponseDto("Datos obtenidos", service.findByStateTrue(), true))
        } catch (e: Exception) {
            ResponseEntity.internalServerError()
                .body(ApiResponseDto(e.message ?: "Error desconocido", null, false))
        }
    }

    @GetMapping("{id}")
    fun show(@PathVariable id: Long): ResponseEntity<ApiResponseDto<T?>> {
        return try {
            val entity = service.findById(id).orElse(null)
            ResponseEntity.ok(ApiResponseDto("Registro encontrado", entity, true))
        } catch (e: Exception) {
            ResponseEntity.internalServerError()
                .body(ApiResponseDto(e.message ?: "Error desconocido", null, false))
        }
    }

    @PostMapping
    fun save(@RequestBody dto: D): ResponseEntity<ApiResponseDto<D>> {
        return try {
            val savedDto = service.save(dto)
            ResponseEntity.ok(ApiResponseDto("Datos guardados", savedDto, true))
        } catch (e: Exception) {
            ResponseEntity.internalServerError()
                .body(ApiResponseDto(e.message ?: "Error al guardar", null, false))
        }
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody entity: T): ResponseEntity<ApiResponseDto<Void>> {
        return try {
            service.update(id, entity)
            ResponseEntity.ok(ApiResponseDto("Datos actualizados", null, true))
        } catch (e: Exception) {
            ResponseEntity.internalServerError()
                .body(ApiResponseDto(e.message ?: "Error al actualizar", null, false))
        }
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<ApiResponseDto<Void>> {
        return try {
            service.delete(id)
            ResponseEntity.ok(ApiResponseDto("Registro eliminado", null, true))
        } catch (e: Exception) {
            ResponseEntity.internalServerError()
                .body(ApiResponseDto(e.message ?: "Error al eliminar", null, false))
        }
    }
}
