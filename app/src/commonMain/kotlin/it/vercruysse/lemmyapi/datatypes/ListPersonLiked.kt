package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.dto.LikeType
import it.vercruysse.lemmyapi.dto.ListingType
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ListPersonLiked(
    val type_: ListingType? /* "All" | "Comments" | "Posts" */ = null,
    val like_type: LikeType? /* "All" | "LikedOnly" | "DislikedOnly" */ = null,
    val page_cursor: PaginationCursor? = null,
    val page_back: Boolean? = null,
    val limit: Long? = null,
) : DatatypeRoot
