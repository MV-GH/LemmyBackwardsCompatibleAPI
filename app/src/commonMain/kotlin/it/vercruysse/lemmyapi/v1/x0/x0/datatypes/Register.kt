package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class Register(
    val username: String,
    val password: SensitiveString,
    val password_verify: SensitiveString,
    val show_nsfw: Boolean? = null,
    val email: SensitiveString? = null,
    val captcha_uuid: String? = null,
    val captcha_answer: String? = null,
    val honeypot: String? = null,
    val answer: String? = null,
)
