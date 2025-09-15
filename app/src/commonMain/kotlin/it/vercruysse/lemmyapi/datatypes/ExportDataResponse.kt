package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ExportDataResponse(
    val notifications: List<PostOrCommentOrPrivateMessage>,
    val content: List<PostOrCommentOrPrivateMessage>,
    val read_posts: List<String>,
    val liked: List<String>,
    val moderates: List<String>,
    val settings: UserSettingsBackup,
) : DatatypeRoot
