package com.example.demo_Kotlin.irespository


import com.sena.servicesecurity.entity.ABaseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface IBaseRepository<T : ABaseEntity, ID> : JpaRepository<T, Long>
