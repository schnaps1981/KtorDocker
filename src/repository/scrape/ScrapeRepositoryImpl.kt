package com.example.repository.scrape

import it.skrape.core.fetcher.BrowserFetcher
import it.skrape.core.htmlDocument
import it.skrape.extractIt
import it.skrape.selects.html5.a
import it.skrape.skrape
import models.Links

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
}
