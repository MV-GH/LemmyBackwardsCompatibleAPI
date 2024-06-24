package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class SiteResponse(
    val site_view: SiteView,
    val taglines: List<Tagline>,
)
