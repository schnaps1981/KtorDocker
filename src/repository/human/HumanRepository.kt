package com.example.repository.human

import com.example.models.Human
import org.jetbrains.exposed.dao.id.EntityID

interface HumanRepository {
    suspend fun addHuman(human: Human): EntityID<Int>

    suspend fun readAllHumans(): List<Human>
}
