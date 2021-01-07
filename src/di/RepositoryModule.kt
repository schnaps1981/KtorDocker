package com.example.di

import com.example.repository.human.HumanRepository
import com.example.repository.human.HumanRepositoryImpl
import com.example.repository.scrape.ScrapeRepository
import com.example.repository.scrape.ScrapeRepositoryImpl
import org.koin.dsl.module
import org.koin.experimental.builder.singleBy

val repositoryModule = module(createdAtStart = true) {
    singleBy<HumanRepository, HumanRepositoryImpl>()
    singleBy<ScrapeRepository, ScrapeRepositoryImpl>()
}