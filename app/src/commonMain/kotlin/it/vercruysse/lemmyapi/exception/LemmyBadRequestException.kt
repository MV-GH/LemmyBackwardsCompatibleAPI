package it.vercruysse.lemmyapi.exception

data class LemmyBadRequestException(val statusCode: Int, val id: String, val additionalMessage: String? = null) : Exception(id)
