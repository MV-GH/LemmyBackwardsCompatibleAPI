package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
    val read: Boolean = false,
    val published_at: String,
    val updated_at: String? = null,
    val ap_id: String,
    val local: Boolean,
    /** Added in Lemmy 1.0.0 */
    val removed: Boolean,
    /** Added in Lemmy 1.0.0 */
    val deleted_by_recipient: Boolean,
) : DatatypeRoot, Identity, PostOrCommentOrPrivateMessage
