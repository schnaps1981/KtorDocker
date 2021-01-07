package com.example.routes

import com.example.repository.scrape.ScrapeRepository
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import it.skrape.core.fetcher.BrowserFetcher
import it.skrape.core.htmlDocument
import it.skrape.extractIt
import it.skrape.selects.html5.a
import it.skrape.skrape
import models.Links

fun Route.scrapeRoutes(scrapeRepository: ScrapeRepository) {
    route("/scrape") {
        get {
            val links = scrapeRepository.scrapeLinks()
            call.respond(links)
        }
    }
}