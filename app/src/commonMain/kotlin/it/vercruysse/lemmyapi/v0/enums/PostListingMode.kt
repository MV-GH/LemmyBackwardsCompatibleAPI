package it.vercruysse.lemmyapi.v0.enums

import kotlinx.serialization.Serializable
import it.vercruysse.lemmyapi.enums.PostListingMode as UniPostListingMode

@Serializable
internal enum class PostListingMode {
    List,
    Card,
    SmallCard,
    ;

    fun toUni(): UniPostListingMode =
        when (this) {
            List -> UniPostListingMode.List
            Card -> UniPostListingMode.Card
            SmallCard -> UniPostListingMode.SmallCard
        }

    companion object {
        fun fromUniNullable(uni: UniPostListingMode?): PostListingMode? =
            when (uni) {
                null -> null
                UniPostListingMode.List -> List
                UniPostListingMode.Card -> Card
                UniPostListingMode.SmallCard -> SmallCard
            }

        fun fromUni(uni: UniPostListingMode): PostListingMode = fromUniNullable(uni) ?: error("No v0 mapping for $uni")
    }
}

internal fun PostListingMode?.toUni(): UniPostListingMode? = this?.toUni()
