package com.example.routes

import io.ktor.application.*
import io.ktor.html.*
import io.ktor.routing.*
import kotlinx.html.*

fun Route.rootRoute() {
    route("/") {
        get {
            call.respondHtml {
                head {
                    title { +"Ktor: jetty" }
                }
                body {
                    p {
                        +"Hello from Ktor Jetty engine sample application -= PARANOID =- "
                    }

                    p {
                        +"Timestamp = ${currentTimeMillis()}"
                    }
                }
            }
        }
    }
}
