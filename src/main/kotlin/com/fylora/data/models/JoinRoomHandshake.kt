package com.fylora.data.models

import com.fylora.util.Constants.TYPE_JOIN_ROOM_HANDSHAKE

data class JoinRoomHandshake(
    val username: String,
    val roomName: String,
    val clientId: String,
): BaseModel(TYPE_JOIN_ROOM_HANDSHAKE)
