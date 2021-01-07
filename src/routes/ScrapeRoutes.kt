package com.example.routes

import com.example.repository.scrape.ScrapeRepository
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.scrapeRoutes(scrapeRepository: ScrapeRepository) {
    route("/scrape") {
        get {
            val links = scrapeRepository.scrapeLinks()

            scrapeRepository.saveLinks(links)

            call.respond(links)
        }
    }
}