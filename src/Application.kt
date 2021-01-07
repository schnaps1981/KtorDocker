package com.example

import com.example.db.DatabaseFactory
import com.example.repository.human.HumanRepositoryImpl
import com.example.routes.humanRoute
import com.example.routes.rootRoute
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.routing.*

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

    DatabaseFactory.init()

    val humanRepository = HumanRepositoryImpl()

    install(Routing) {
        rootRoute()
        humanRoute(humanRepository)
    }
}
