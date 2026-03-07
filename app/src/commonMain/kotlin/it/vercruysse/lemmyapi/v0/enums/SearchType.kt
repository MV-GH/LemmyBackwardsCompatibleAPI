package it.vercruysse.lemmyapi.v0.enums

import it.vercruysse.lemmyapi.enums.SearchType as UniSearchType
import kotlinx.serialization.Serializable

@Serializable
internal enum class SearchType {
    All,
    Comments,
    Posts,
    Communities,
    Users,
    Url,
    ;

    fun toUni(): UniSearchType =
        when (this) {
            All -> UniSearchType.All
            Comments -> UniSearchType.Comments
            Posts -> UniSearchType.Posts
            Communities -> UniSearchType.Communities
            Users -> UniSearchType.Users
            Url -> UniSearchType.Url
        }

    companion object {
        fun fromUniNullable(uni: UniSearchType?): SearchType? =
            when (uni) {
                null -> null
                UniSearchType.All -> All
                UniSearchType.Comments -> Comments
                UniSearchType.Posts -> Posts
                UniSearchType.Communities -> Communities
                UniSearchType.Users -> Users
                UniSearchType.Url -> Url
            }

        fun fromUni(uni: UniSearchType): SearchType = fromUniNullable(uni) ?: error("No v0 mapping for $uni")
    }
}

internal fun SearchType?.toUni(): UniSearchType? = this?.toUni()
