package com.example

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.util.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

suspend inline fun <reified T> ApplicationCall.respondObject(obj: T) {
    runCatching {
        respondText {
            Json.encodeToString(obj)
        }
    }.onFailure { it.printStackTrace() }
}

suspend inline fun <reified T> ApplicationCall.body() =
    Json.decodeFromString<T>(receiveParameters().getOrFail("body"))