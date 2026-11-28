package it.vercruysse.lemmyapi.v0

import it.vercruysse.lemmyapi.datatypes.FederatedInstanceView
import it.vercruysse.lemmyapi.datatypes.FederationAllowList
import it.vercruysse.lemmyapi.datatypes.FederationBlockList
import it.vercruysse.lemmyapi.datatypes.FederationQueueState
import it.vercruysse.lemmyapi.datatypes.GetFederatedInstances
import it.vercruysse.lemmyapi.datatypes.Instance
import it.vercruysse.lemmyapi.datatypes.PagedResponse
import it.vercruysse.lemmyapi.enums.GetFederatedInstancesKind
import it.vercruysse.lemmyapi.utils.LegacyPaging

/**
 * Pre 1.0 Lemmy returns all federated instances at once, as linked, allowed and blocked lists.
 * This filters them like the 1.0 endpoint and pages them client side.
 *
 * The allow and block list entries have no dates of their own pre 1.0, so they use the instance's dates.
 */
internal object LegacyFederatedInstances {
    class Entry(val instance: Instance, val queueState: FederationQueueState? = null)

    fun page(
        form: GetFederatedInstances,
        page: Long,
        linked: List<Entry>,
        allowed: List<Entry>,
        blocked: List<Entry>,
    ): PagedResponse<FederatedInstanceView> {
        val allowedIds = allowed.map { it.instance.id }.toSet()
        val blockedIds = blocked.map { it.instance.id }.toSet()
        val selected = when (form.kind) {
            GetFederatedInstancesKind.All -> (linked + allowed + blocked).distinctBy { it.instance.id }
            GetFederatedInstancesKind.Linked -> linked
            GetFederatedInstancesKind.Allowed -> allowed
            GetFederatedInstancesKind.Blocked -> blocked
        }
        val views = selected
            .filter { form.domain_filter == null || it.instance.domain.contains(form.domain_filter, ignoreCase = true) }
            .map { entry ->
                val instance = entry.instance
                FederatedInstanceView(
                    instance = instance,
                    queue_state = entry.queueState,
                    blocked = if (instance.id in blockedIds) FederationBlockList(instance.published_at, instance.updated_at) else null,
                    allowed = if (instance.id in allowedIds) FederationAllowList(instance.published_at, instance.updated_at) else null,
                )
            }
        return LegacyPaging.slice(views, page, form.limit)
    }
}
