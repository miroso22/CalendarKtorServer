package com.example.data

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class Event(
    val id: Int = 0,
    val date: Long,
    val name: String,
    val description: String
)

internal object Events : Table() {
    val id = integer("id").autoIncrement()
    val date = long("date")
    val name = varchar("name", 128)
    val description = varchar("description", 1024)

    override val primaryKey = PrimaryKey(id)
}