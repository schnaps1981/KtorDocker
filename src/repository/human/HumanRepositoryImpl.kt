package com.example.repository.human

import com.example.db.dbQuery
import com.example.db.tables.HumanTable
import com.example.db.tables.toHuman
import com.example.models.Human
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.selectAll

class HumanRepositoryImpl : HumanRepository {
    override suspend fun addHuman(human: Human) =
        dbQuery {
            HumanTable.insertAndGetId {
                it[name] = human.name
                it[age] = human.age
                it[height] = human.height
                it[weight] = human.weight
                it[isMale] = human.isMale
            }
        }

    override suspend fun readAllHumans(): List<Human> =
        dbQuery {
            HumanTable.selectAll().map {
                it.toHuman()
            }
        }
}
