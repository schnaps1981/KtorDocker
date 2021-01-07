package com.example.repository.scrape

import com.example.db.dbQuery
import com.example.db.tables.HumanTable
import com.example.db.tables.LinksTable
import com.example.db.tables.PagesTable
import it.skrape.core.fetcher.BrowserFetcher
import it.skrape.core.htmlDocument
import it.skrape.extractIt
import it.skrape.selects.html5.a
import it.skrape.skrape
import models.Links
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.insertAndGetId

class ScrapeRepositoryImpl : ScrapeRepository {
    override suspend fun scrapeLinks(): Links =
        skrape(BrowserFetcher) {
            request {
                url = "https://orakul.com/horoscope/astrologic/more/aries/tomorrow.html"
            }

            extractIt {
                it.url = baseUri

                htmlDocument {
                    it.links = a {
                        findAll { this@htmlDocument.eachHref }.filter<String> { url ->
                            url.startsWith("https://orakul.com") && (url.endsWith(".html") || url.endsWith("/"))
                        }
                    }
                }
            }
        }

    override suspend fun saveLinks(links: Links) {
        dbQuery {
            val id = PagesTable.insertAndGetId {
                it[url] = links.url
            }

            links.links.forEach { onPageUrl ->
                LinksTable.insert {
                    it[link] = onPageUrl
                    it[pageId] = id.value
                }
            }
        }

    }
}
