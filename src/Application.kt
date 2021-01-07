package com.example

import com.example.db.DatabaseFactory
import com.example.db.tables.HumanTable
import com.example.di.repositoryModule
import com.example.repository.human.HumanRepository
import com.example.repository.scrape.ScrapeRepository
import com.example.routes.humanRoute
import com.example.routes.rootRoute
import com.example.routes.scrapeRoutes
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.routing.*
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
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

    transaction {
        SchemaUtils.create(HumanTable)
    }

    val humanRepository by inject<HumanRepository>()
    val scrapeRepository by inject<ScrapeRepository>()

    install(Routing) {
        rootRoute()
        humanRoute(humanRepository)
        scrapeRoutes(scrapeRepository)
    }
}
