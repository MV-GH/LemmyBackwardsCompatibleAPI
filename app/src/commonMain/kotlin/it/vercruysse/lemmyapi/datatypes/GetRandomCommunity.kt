package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.dto.ListingType
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class GetRandomCommunity(
    val type_: ListingType? /* "All" | "Local" | "Subscribed" | "ModeratorView" */ = null,
    val show_nsfw: Boolean? = null,
): DatatypeRoot
