package it.vercruysse.lemmyapi.v0.enums

import kotlinx.serialization.Serializable
import it.vercruysse.lemmyapi.enums.PostFeatureType as UniPostFeatureType

@Serializable
internal enum class PostFeatureType {
    Local,
    Community,
    ;

    fun toUni(): UniPostFeatureType =
        when (this) {
            Local -> UniPostFeatureType.Local
            Community -> UniPostFeatureType.Community
        }

    companion object {
        fun fromUniNullable(uni: UniPostFeatureType?): PostFeatureType? =
            when (uni) {
                null -> null
                UniPostFeatureType.Local -> Local
                UniPostFeatureType.Community -> Community
            }

        fun fromUni(uni: UniPostFeatureType): PostFeatureType = fromUniNullable(uni) ?: error("No v0 mapping for $uni")
    }
}

internal fun PostFeatureType?.toUni(): UniPostFeatureType? = this?.toUni()
