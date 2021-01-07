package com.example.db.tables

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object LinksTable: IntIdTable("links") {
    val link: Column<String> = HumanTable.text("link")
    val pageId: Column<Int> = HumanTable.integer("page_id")
}