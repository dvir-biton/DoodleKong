package com.fylora

import com.fylora.plugins.configureMonitoring
import com.fylora.plugins.configureRouting
import com.fylora.plugins.configureSerialization
import com.fylora.plugins.configureSockets
import com.fylora.session.DrawingSession
import com.google.gson.Gson
import io.ktor.application.*
import io.ktor.sessions.*
import io.ktor.util.*

val server = DrawingServer()
val gson = Gson()

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureSockets()
    configureMonitoring()
    configureRouting()

    install(Sessions) {
        cookie<DrawingSession>("SESSION")
    }
    intercept(ApplicationCallPipeline.Features) {
        if(call.sessions.get<DrawingSession>() == null) {
            val clientId = call.parameters["client_id"] ?: ""
            call.sessions.set(DrawingSession(clientId, generateNonce()))
        }
    }
}
