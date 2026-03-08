package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize
import kotlinx.serialization.SerialName

@CommonParcelize
@Serializable
@SerialName("private_message")
data class PrivateMessage(
    override val id: PrivateMessageId,
    val creator_id: PersonId,
    val recipient_id: PersonId,
    val content: String,
    val deleted: Boolean,
    /** Removed in 1.0.0 */
    val read: Boolean,
    val published_at: String,
    val updated_at: String? = null,
    val ap_id: String,
    val local: Boolean,
    /** Added in Lemmy 1.0.0 */
    val removed: Boolean,
) : DatatypeRoot, Identity, PostOrCommentOrPrivateMessage
