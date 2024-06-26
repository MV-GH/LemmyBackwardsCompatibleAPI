package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class Comment(
    override val id: CommentId,
    val creator_id: PersonId,
    val post_id: PostId,
    val content: String,
    val removed: Boolean,
    val published: String,
    val updated: String? = null,
    val deleted: Boolean,
    val ap_id: String,
    val local: Boolean,
    val path: String,
    val distinguished: Boolean,
    val language_id: LanguageId,
) : DatatypeRoot, Identity
