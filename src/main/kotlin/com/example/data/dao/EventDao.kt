package com.example.data.dao

import com.example.data.Event

interface EventDao {
    suspend fun getEvents(): List<Event>
    suspend fun addEvent(event: Event)
}