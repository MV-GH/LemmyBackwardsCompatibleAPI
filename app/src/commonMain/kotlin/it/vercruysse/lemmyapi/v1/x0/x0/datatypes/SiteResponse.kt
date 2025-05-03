package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class SiteResponse(
    val site_view: SiteView,
    val taglines: List<Nothing?> = null,
)
