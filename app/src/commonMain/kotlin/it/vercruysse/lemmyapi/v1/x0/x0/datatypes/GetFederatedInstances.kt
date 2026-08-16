package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.GetFederatedInstancesKind
import kotlinx.serialization.Serializable

@Serializable
internal data class GetFederatedInstances(
    val domain_filter: String? = null,
    val kind: GetFederatedInstancesKind /* "all" | "linked" | "allowed" | "blocked" */,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
)
