package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class SiteView(
    val site: Site,
    val local_site: LocalSite,
    val local_site_rate_limit: LocalSiteRateLimit,
    val instance: Instance,
)
