package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.dto.ListingType
import kotlinx.serialization.Serializable

@Serializable
internal data class GetRandomCommunity(
    val type_: ListingType? /* "all" | "local" | "subscribed" | "moderator_view" | "suggested" */ = null,
    val show_nsfw: Boolean? = null,
)
