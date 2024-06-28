package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class Register(
    val username: String,
    val password: String,
    val password_verify: String,
// TODO    val show_nsfw: Boolean? = null,
    val show_nsfw: Boolean,
    val email: String? = null,
    val captcha_uuid: String? = null,
    val captcha_answer: String? = null,
    val honeypot: String? = null,
    val answer: String? = null,
) : DatatypeRoot
