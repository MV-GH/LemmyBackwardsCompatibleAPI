package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class AddAdminResponse(
    val admins: List<PersonView>,
)
