package com.example

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.html.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.html.body
import kotlinx.html.head
import kotlinx.html.p
import kotlinx.html.title
import kotlin.random.Random

fun Application.main() {
    install(DefaultHeaders)
    install(CallLogging)

    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
            serializeNulls()
        }
    }

    routing {
        get("/") {
            call.respondHtml {
                head {
                    title { +"Ktor: jetty" }
                }
                body {
                    p {
                        +"Hello from Ktor Jetty engine sample application -= PARANOID =- "
                    }
                }
            }
        }

        get("/gson") {
            call.respond(Human(
                name = listOf("Vasili", "Aleksey", "Ivan", "Viktor").shuffled().first(),
                age = Random.nextInt(10, 60),
                weight = Random.nextInt(50, 120),
                height = Random.nextInt(155, 205),
                isMale = Random.nextBoolean()
            ))
        }
    }
}
