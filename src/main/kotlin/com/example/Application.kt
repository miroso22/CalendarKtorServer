package com.example

import com.example.data.DatabaseFactory
import com.example.plugins.configureRouting
import com.example.plugins.configureTemplates
import io.ktor.server.application.*
import io.ktor.server.netty.*
import kotlinx.serialization.Serializable

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    DatabaseFactory.init()
    configureTemplates()
    configureRouting()
}
