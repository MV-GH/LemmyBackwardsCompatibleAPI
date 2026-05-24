package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
@SerialName("person")
data class PersonView(
    val person: Person,
    val is_admin: Boolean,
    val person_actions: PersonActions? = null,
    val banned: Boolean,
    val ban_expires_at: String? = null,
) : DatatypeRoot, ResolveObjectView
