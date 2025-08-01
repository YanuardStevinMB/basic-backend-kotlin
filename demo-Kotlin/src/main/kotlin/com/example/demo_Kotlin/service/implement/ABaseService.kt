package com.example.demo_Kotlin.service.implement

import com.example.demo_Kotlin.irespository.IBaseRepository
import com.example.demo_Kotlin.service.`interface`.IBaseService
import com.example.demo_Kotlin.utilitis.GenericMapper
import com.sena.servicesecurity.entity.ABaseEntity
import org.springframework.beans.BeanUtils
import java.time.LocalDateTime
import java.util.Optional


abstract class ABaseService<T : ABaseEntity, D>(
    private val mapper: GenericMapper,
    private val entityClass: Class<T>,
    private val dtoClass: Class<D>
) : IBaseService<T,D>{

    protected abstract fun getRepository(): IBaseRepository<T, Long>

    @Throws(Exception::class)
    override fun all(): List<T> {
        return getRepository().findAll()
    }

    @Throws(Exception::class)
    override fun findByStateTrue(): List<T> {
        return getRepository().findAll() // O ajusta según lógica real (filtrar por state = true)
    }

    @Throws(Exception::class)
    override fun findById(id: Long): Optional<T> {
        val op = getRepository().findById(id)
        if (op.isEmpty) throw Exception("Registro no encontrado")
        return op;
    }

    @Throws(Exception::class)
    override fun save(dto: D): D {
        return try {
            val entity = mapper.mapToEntity(dto, entityClass)
            entity.createdAt = LocalDateTime.now()
            entity.createdBy = 1L // Esto puede ser dinámico según el usuario autenticado
            val saved = getRepository().save(entity)
            mapper.mapToDto(saved, dtoClass)
        } catch (e: Exception) {
            throw Exception("Error al guardar la entidad: ${e.message}", e)
        }
    }


    @Throws(Exception::class)
    override fun update(id: Long, entity: T) {
        val op = getRepository().findById(id)
        if (op.isEmpty) throw Exception("Registro no encontrado")
        if (op.get().deletedAt != null) throw Exception("Registro inhabilitado")

        val entityUpdate = op.get()
        val ignoreProperties = arrayOf("id", "createdAt", "deletedAt", "createdBy", "deletedBy")
        BeanUtils.copyProperties(entity, entityUpdate, *ignoreProperties)
        entityUpdate.updatedAt = LocalDateTime.now()
        entityUpdate.updatedBy = 1L // Reemplazar con Auth
        getRepository().save(entityUpdate)
    }

    @Throws(Exception::class)
    override fun delete(id: Long) {
        val op = getRepository().findById(id)
        if (op.isEmpty) throw Exception("Registro no encontrado")

        val entityUpdate = op.get()
        entityUpdate.deletedAt = LocalDateTime.now()
        entityUpdate.deletedBy = 1L // Reemplazar con Auth
        getRepository().save(entityUpdate)
    }
}