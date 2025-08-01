package com.example.demo_Kotlin.config

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import javax.sql.DataSource

class StartupChecker(private  val dataSource: DataSource): ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        try {
            dataSource.connection.use {
                println("✅ Conexión a la base de datos exitosa.")
            }
        } catch (ex: Exception) {
            println("❌ No se pudo conectar a la base de datos.")
            println("💡 Asegúrate de que PostgreSQL está corriendo y el puerto 5433 está disponible.")
            throw IllegalStateException("Error de conexión a base de datos", ex)
        }
    }
}