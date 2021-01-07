package com.example.di

import com.example.repository.human.HumanRepository
import com.example.repository.human.HumanRepositoryImpl
import org.koin.dsl.module
import org.koin.experimental.builder.singleBy

val repositoryModule = module(createdAtStart = true){
    singleBy<HumanRepository, HumanRepositoryImpl>()
}