package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class Register(
    val username: String,
    val password: SensitiveString,
    val password_verify: SensitiveString,
    val show_nsfw: Boolean? = null,
    val email: SensitiveString? = null,
    val captcha_uuid: String? = null,
    val captcha_answer: String? = null,
    val honeypot: String? = null,
    val answer: String? = null,
    /** Added in 1.0.0 */
    val stay_logged_in: Boolean? = null,
) : DatatypeRoot
