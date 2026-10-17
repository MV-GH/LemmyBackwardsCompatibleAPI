package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.GetFederatedInstancesKind
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class GetFederatedInstances(
    val domain_filter: String? = null,
    val kind: GetFederatedInstancesKind /* "all" | "linked" | "allowed" | "blocked" */,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
) : DatatypeRoot
