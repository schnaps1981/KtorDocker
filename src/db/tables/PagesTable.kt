package com.example.db.tables

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object PagesTable : IntIdTable("pages") {
    val url: Column<String> = HumanTable.text("url")
}
