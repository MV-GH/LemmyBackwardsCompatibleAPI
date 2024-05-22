package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationApplicationView(
    val registration_application: RegistrationApplication,
    val creator_local_user: LocalUser,
    val creator: Person,
    val admin: Person? = null,
)
