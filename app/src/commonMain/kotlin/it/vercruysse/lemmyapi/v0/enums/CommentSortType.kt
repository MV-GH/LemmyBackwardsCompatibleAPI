package it.vercruysse.lemmyapi.v0.enums

import it.vercruysse.lemmyapi.enums.CommentSortType as UniCommentSortType
import kotlinx.serialization.Serializable

@Serializable
internal enum class CommentSortType {
    Hot,
    Top,
    New,
    Old,
    Controversial,
    ;

    fun toUni(): UniCommentSortType =
        when (this) {
            Hot -> UniCommentSortType.Hot
            Top -> UniCommentSortType.Top
            New -> UniCommentSortType.New
            Old -> UniCommentSortType.Old
            Controversial -> UniCommentSortType.Controversial
        }

    companion object {
        fun fromUniNullable(uni: UniCommentSortType?): CommentSortType? =
            when (uni) {
                null -> null
                UniCommentSortType.Hot -> Hot
                UniCommentSortType.Top -> Top
                UniCommentSortType.New -> New
                UniCommentSortType.Old -> Old
                UniCommentSortType.Controversial -> Controversial
            }

        fun fromUni(uni: UniCommentSortType): CommentSortType = fromUniNullable(uni) ?: error("No v0 mapping for $uni")
    }
}

internal fun CommentSortType?.toUni(): UniCommentSortType? = this?.toUni()
