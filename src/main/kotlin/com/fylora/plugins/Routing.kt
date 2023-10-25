package com.fylora.plugins

import com.fylora.routes.createRoomRoute
import com.fylora.routes.gameWebSocketRoute
import com.fylora.routes.getRoomRoute
import com.fylora.routes.joinRoomRoute
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("dayum")
        }
    }
    routing {
        getRoomRoute()
        createRoomRoute()
        joinRoomRoute()
        gameWebSocketRoute()
    }
}
