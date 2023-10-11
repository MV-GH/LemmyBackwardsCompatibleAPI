package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class LocalUserView(
    val local_user: LocalUser,
    val person: Person,
    val counts: PersonAggregates,
)
