package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class SiteResponse(
    val site_view: SiteView,
    val taglines: List<Tagline>,
)
