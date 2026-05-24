package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.ListingType
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class GetRandomCommunity(
    val type_: ListingType? /* "All" | "Local" | "Subscribed" | "ModeratorView" | "Suggested" */ = null,
    val show_nsfw: Boolean? = null,
) : DatatypeRoot
