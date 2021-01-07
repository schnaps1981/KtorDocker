package com.example.repository.scrape

import models.Links

interface ScrapeRepository {
    suspend fun scrapeLinks(): Links
}