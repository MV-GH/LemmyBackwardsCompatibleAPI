import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import it.vercruysse.lemmyapi.LemmyApiClient
import it.vercruysse.lemmyapi.LemmyInstance
import it.vercruysse.lemmyapi.LemmyVersion
import it.vercruysse.lemmyapi.datatypes.GetFederatedInstances
import it.vercruysse.lemmyapi.enums.GetFederatedInstancesKind
import it.vercruysse.lemmyapi.utils.LegacyPaging
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class LegacyFederatedInstancesTest {
    private fun instance(id: Int, domain: String) = """{"id":$id,"domain":"$domain","published":"2024-01-01T00:00:00Z"}"""

    private val response = """
        {"federated_instances":{
            "linked":[${instance(1, "alpha.com")},${instance(2, "beta.org")}],
            "allowed":[${instance(2, "beta.org")}],
            "blocked":[${instance(3, "gamma.net")}]
        }}
    """.trimIndent()

    @Test
    fun `legacy federated instances are filtered and paged client side`() = runBlocking {
        for (version in listOf("0.18.5", "0.19.0", "0.19.3", "0.19.4", "0.19.6", "0.19.11")) {
            val client = HttpClient(
                MockEngine { request ->
                    assertEquals("/api/v3/federated_instances", request.url.encodedPath)
                    respond(response, HttpStatusCode.OK, headersOf(HttpHeaders.ContentType, "application/json"))
                },
            )
            val apiClient = LemmyApiClient(client)
            try {
                val api = apiClient.connectForVersion(LemmyInstance("lemmy.ml"), LemmyVersion(version)).getOrThrow()

                val all = api.getFederatedInstances(GetFederatedInstances(kind = GetFederatedInstancesKind.All)).getOrThrow()
                assertEquals(listOf(1L, 2L, 3L), all.items.map { it.instance.id }, version)
                assertNull(all.items[0].allowed)
                assertNotNull(all.items[1].allowed)
                assertNotNull(all.items[2].blocked)
                assertNull(all.next_page)

                val blocked = api.getFederatedInstances(GetFederatedInstances(kind = GetFederatedInstancesKind.Blocked)).getOrThrow()
                assertEquals(listOf("gamma.net"), blocked.items.map { it.instance.domain })

                val filtered = api.getFederatedInstances(GetFederatedInstances(kind = GetFederatedInstancesKind.Linked, domain_filter = "BETA")).getOrThrow()
                assertEquals(listOf(2L), filtered.items.map { it.instance.id })

                val first = api.getFederatedInstances(GetFederatedInstances(kind = GetFederatedInstancesKind.All, limit = 2)).getOrThrow()
                assertEquals(listOf(1L, 2L), first.items.map { it.instance.id })
                assertEquals(LegacyPaging.encode(2), first.next_page)
                val second = api.getFederatedInstances(GetFederatedInstances(kind = GetFederatedInstancesKind.All, page_cursor = first.next_page, limit = 2)).getOrThrow()
                assertEquals(listOf(3L), second.items.map { it.instance.id })
                assertNull(second.next_page)
                assertEquals(LegacyPaging.encode(1), second.prev_page)
                val far = api.getFederatedInstances(
                    GetFederatedInstances(kind = GetFederatedInstancesKind.All, page_cursor = LegacyPaging.encode(Int.MAX_VALUE.toLong()), limit = Long.MAX_VALUE),
                ).getOrThrow()
                assertEquals(emptyList(), far.items, version)
                val wrapping = api.getFederatedInstances(GetFederatedInstances(kind = GetFederatedInstancesKind.All, limit = (1L shl 32) + 1)).getOrThrow()
                assertEquals(3, wrapping.items.size, version)
            } finally {
                apiClient.close()
                client.close()
            }
        }
    }
}
