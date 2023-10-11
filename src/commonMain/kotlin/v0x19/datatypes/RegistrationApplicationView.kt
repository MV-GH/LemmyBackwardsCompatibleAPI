package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationApplicationView(
    val registration_application: RegistrationApplication,
    val creator_local_user: LocalUser,
    val creator: Person,
    val admin: Person? = null,
)
