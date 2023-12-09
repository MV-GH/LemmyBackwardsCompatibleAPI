package it.vercruysse.lemmyapi.exception

import io.ktor.client.statement.*

data class LemmyBadRequestException(
    val code: Int,
    val msg: String,
    val response: HttpResponse,
) : Exception(msg)
