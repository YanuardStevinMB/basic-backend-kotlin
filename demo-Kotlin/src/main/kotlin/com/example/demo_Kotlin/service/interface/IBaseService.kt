package com.example.demo_Kotlin.service.`interface`

import com.sena.servicesecurity.entity.ABaseEntity
import java.util.Optional

interface IBaseService <T: ABaseEntity,D>{
    /**
     * Recupera todas las entidades.
     * @return Una lista de todas las entidades.
     * @throws Exception Si ocurre un error durante la recuperación.
     */
    @Throws(Exception::class)
    fun all(): List<T>

    /**
     * Recupera todas las entidades con state = true.
     * @return Una lista de entidades activas.
     * @throws Exception Si ocurre un error durante la recuperación.
     */
//    @Throws(Exception::class)
//    fun findByStateTrue(): List<T>

    /**
     * Recupera una entidad por su ID.
     * @param id ID de la entidad.
     * @return Un Optional que contiene la entidad, o vacío si no se encuentra.
     * @throws Exception Si ocurre un error durante la recuperación.
     */
    @Throws(Exception::class)
    fun findById(id: Long): Optional<T>

    /**
     * Guarda una entidad.
     * @param entity Entidad a guardar.
     * @return La entidad guardada.
     * @throws Exception Si ocurre un error durante el guardado.
     */
    @Throws(Exception::class)
    fun save(dto: D): D

    /**
     * Actualiza una entidad existente por su ID.
     * @param id ID de la entidad a actualizar.
     * @param entity Entidad actualizada.
     * @throws Exception Si ocurre un error durante la actualización.
     */
    @Throws(Exception::class)
    fun update(id: Long, entity: T)

    /**
     * Elimina una entidad por su ID.
     * @param id ID de la entidad a eliminar.
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    @Throws(Exception::class)
    fun delete(id: Long)
}