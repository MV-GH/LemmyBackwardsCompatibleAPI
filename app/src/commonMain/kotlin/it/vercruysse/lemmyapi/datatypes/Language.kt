package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class Language(
    override val id: LanguageId,
    val code: String,
    val name: String,
    /** Added in 1.0.0 */
    val usage_in_local_posts_percent: Long,
    /** Added in 1.0.0 */
    val usage_in_local_comments_percent: Long,
) : DatatypeRoot, Identity
