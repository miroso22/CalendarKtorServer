package com.example.data.dao

import com.example.data.Event
import com.example.data.Events
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

internal class EventDaoImpl : EventDao {

    private fun rowToEvent(row: ResultRow) = Event(
        id = row[Events.id],
        date = row[Events.date],
        name = row[Events.name],
        description = row[Events.description]
    )

    override suspend fun getEvents() = newSuspendedTransaction(Dispatchers.IO) {
        Events.selectAll().map(::rowToEvent)
    }

    override suspend fun addEvent(event: Event): Unit = newSuspendedTransaction(Dispatchers.IO) {
        Events.insert {
            it[date] = event.date
            it[name] = event.name
            it[description] = event.description
        }
    }
}