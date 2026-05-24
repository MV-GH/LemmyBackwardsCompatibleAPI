package it.vercruysse.lemmyapi.v0.enums

import kotlinx.serialization.Serializable
import it.vercruysse.lemmyapi.enums.CommunityVisibility as UniCommunityVisibility

@Serializable
internal enum class CommunityVisibility {
    Public,
    LocalOnly,
    ;

    fun toUni(): UniCommunityVisibility =
        when (this) {
            Public -> UniCommunityVisibility.Public
            LocalOnly -> UniCommunityVisibility.LocalOnly
        }

    companion object {
        fun fromUniNullable(uni: UniCommunityVisibility?): CommunityVisibility? =
            when (uni) {
                null -> null
                UniCommunityVisibility.Public -> Public
                UniCommunityVisibility.LocalOnly -> LocalOnly
                else -> null
            }

        fun fromUni(uni: UniCommunityVisibility): CommunityVisibility = fromUniNullable(uni) ?: error("No v0 mapping for $uni")
    }
}

internal fun CommunityVisibility?.toUni(): UniCommunityVisibility? = this?.toUni()
