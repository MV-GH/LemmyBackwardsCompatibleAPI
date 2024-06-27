package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class SiteResponse(
    val site_view: SiteView,
    val taglines: List<Tagline>,
)
