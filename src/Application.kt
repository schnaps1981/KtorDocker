package com.example

import com.example.db.DatabaseFactory
import com.example.di.repositoryModule
import com.example.repository.human.HumanRepository
import com.example.routes.humanRoute
import com.example.routes.rootRoute
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.routing.*
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.inject

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.main() {
    install(DefaultHeaders)

    install(CallLogging)

    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
            serializeNulls()
        }
    }

    install(Koin) {
        modules(repositoryModule)
    }

    DatabaseFactory.init()

    val humanRepository by inject<HumanRepository>()

    install(Routing) {
        rootRoute()
        humanRoute(humanRepository)
    }
}
