package com.example.plugins

import com.example.data.DatabaseFactory.dao
import com.example.data.Event
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/events") {
            call.respond(dao.getEvents())
        }
        post("/event/add") {
            val event: Event = call.receive()
            dao.addEvent(event)
            call.respond("")
        }
    }
}