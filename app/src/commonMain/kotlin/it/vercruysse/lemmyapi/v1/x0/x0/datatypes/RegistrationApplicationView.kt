package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class RegistrationApplicationView(
    val registration_application: RegistrationApplication,
    val creator_local_user: LocalUser,
    val creator: Person,
    val admin: Person? = null,
)
