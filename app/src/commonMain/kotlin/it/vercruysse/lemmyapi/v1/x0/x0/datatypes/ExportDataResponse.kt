package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ExportDataResponse(
    val notifications: List<PostOrCommentOrPrivateMessage>,
    val content: List<PostOrCommentOrPrivateMessage>,
    val read_posts: List<String>,
    val liked: List<String>,
    val moderates: List<String>,
    val settings: UserSettingsBackup,
)
