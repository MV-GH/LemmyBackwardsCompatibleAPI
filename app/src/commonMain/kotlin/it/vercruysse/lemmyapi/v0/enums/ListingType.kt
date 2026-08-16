package it.vercruysse.lemmyapi.v0.enums

import kotlinx.serialization.Serializable
import it.vercruysse.lemmyapi.enums.ListingType as UniListingType

@Serializable
internal enum class ListingType {
    All,
    Local,
    Subscribed,
    ModeratorView,
    ;

    fun toUni(): UniListingType =
        when (this) {
            All -> UniListingType.All
            Local -> UniListingType.Local
            Subscribed -> UniListingType.Subscribed
            ModeratorView -> UniListingType.ModeratorView
        }

    companion object {
        fun fromUniNullable(uni: UniListingType?): ListingType? =
            when (uni) {
                null -> null
                UniListingType.All -> All
                UniListingType.Local -> Local
                UniListingType.Subscribed -> Subscribed
                UniListingType.ModeratorView -> ModeratorView
                else -> null
            }

        fun fromUni(uni: UniListingType): ListingType = fromUniNullable(uni) ?: error("No v0 mapping for $uni")
    }
}

internal fun ListingType?.toUni(): UniListingType? = this?.toUni()
