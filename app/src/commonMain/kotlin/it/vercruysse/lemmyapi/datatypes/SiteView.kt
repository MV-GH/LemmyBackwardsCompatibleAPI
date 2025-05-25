package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO: changes

@CommonParcelize
@Serializable
data class SiteView(
    val site: Site,
    val local_site: LocalSite,
    val local_site_rate_limit: LocalSiteRateLimit,
    val counts: SiteAggregates,
) : DatatypeRoot, Identity {
    override val id: Long
        get() = site.id
}
