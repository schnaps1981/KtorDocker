package com.example.db

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database

object DatabaseFactory {

    fun init() {
        Database.connect(hikari())
    }

    private fun hikari(): HikariDataSource {
        val config = HikariConfig()
        config.driverClassName = "org.postgresql.Driver"
        config.jdbcUrl =
            "jdbc:postgresql://rogue.db.elephantsql.com:5432/jbulkskp?user=jbulkskp&password=H1_gzcufh9ScTivCW9bTl4VCvEcVM0S0&ssl=false"

        config.username = "jbulkskp"
        config.password = "H1_gzcufh9ScTivCW9bTl4VCvEcVM0S0"
        config.maximumPoolSize = 3
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.validate()
        return HikariDataSource(config)
    }
}
