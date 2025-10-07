package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

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
) : DatatypeRoot
