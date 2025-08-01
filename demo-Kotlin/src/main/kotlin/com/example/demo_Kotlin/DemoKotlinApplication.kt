package com.example.demo_Kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoKotlinApplication

fun main(args: Array<String>) {
	try {
		runApplication<DemoKotlinApplication>(*args)
	} catch (ex: Exception) {
		println("❌ Error al iniciar la aplicación: ${ex.localizedMessage}")
		ex.printStackTrace() // ✅ Imprime el stacktrace completo
		println("💡 Verifica que la base de datos esté encendida y configurada correctamente.")
	}
}
