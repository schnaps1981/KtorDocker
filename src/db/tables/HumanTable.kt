package com.example.db.tables

import com.example.models.Human
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ResultRow

object HumanTable : IntIdTable("users") {
    val name: Column<String> = HumanTable.text("name")
    val age: Column<Int> = HumanTable.integer("age")
    val weight: Column<Int> = HumanTable.integer("weight")
    val height: Column<Int> = HumanTable.integer("height")
    val isMale: Column<Boolean> = HumanTable.bool("isMale")
}

fun ResultRow.toHuman() = Human(
    name = this[HumanTable.name],
    age = this[HumanTable.age],
    weight = this[HumanTable.weight],
    height = this[HumanTable.height],
    isMale = this[HumanTable.isMale]
)
