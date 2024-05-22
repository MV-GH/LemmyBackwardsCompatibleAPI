package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class SiteView(
    val site: Site,
    val local_site: LocalSite,
    val local_site_rate_limit: LocalSiteRateLimit,
    val counts: SiteAggregates,
)
