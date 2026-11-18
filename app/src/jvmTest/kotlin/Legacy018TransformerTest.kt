import it.vercruysse.lemmyapi.IGNORE_UNKNOWN_KEYS_JSON
import it.vercruysse.lemmyapi.v0.x18.x5.Transformer
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.LocalUserView as X5LocalUserView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PersonView as X5PersonView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PostReport as X5PostReport
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PostView as X5PostView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.RegistrationApplication as X5RegistrationApplication

class Legacy018TransformerTest {
    private val transformer = Transformer("token")

    private fun <T> decode(serializer: KSerializer<T>, json: JsonElement): T = IGNORE_UNKNOWN_KEYS_JSON.decodeFromJsonElement(serializer, json)

    private fun JsonObject.with(field: String, value: JsonElement) = JsonObject(this + (field to value))

    private fun adminPerson(descriptor: kotlinx.serialization.descriptors.SerialDescriptor) =
        (sample(descriptor) as JsonObject).with("admin", JsonPrimitive(true))

    @Test
    fun `admin flags are taken from the 0_18 person`() {
        val personView = X5PersonView.serializer()
        val person = decode(personView, objectWith(personView.descriptor, "person" to adminPerson(personView.descriptor.element("person"))))
        assertTrue(transformer.toUni(person).is_admin)

        val localUserView = X5LocalUserView.serializer()
        val localUser = decode(localUserView, objectWith(localUserView.descriptor, "person" to adminPerson(localUserView.descriptor.element("person"))))
        assertTrue(transformer.toUni(localUser).local_user.admin)

        val postView = X5PostView.serializer()
        val post = decode(postView, objectWith(postView.descriptor, "creator" to adminPerson(postView.descriptor.element("creator"))))
        assertTrue(transformer.toUni(post).creator_is_admin)
    }

    @Test
    fun `0_18 timestamps get a timezone`() {
        val report = X5PostReport.serializer()
        val postReport = decode(report, objectWith(report.descriptor, "published" to JsonPrimitive("2023-01-01T00:00:00"), "updated" to JsonPrimitive("2023-01-02T00:00:00")))
        assertEquals("2023-01-02T00:00:00Z", transformer.toUni(postReport).updated_at)

        val application = X5RegistrationApplication.serializer()
        val registration = decode(application, objectWith(application.descriptor, "published" to JsonPrimitive("2023-01-01T00:00:00")))
        assertEquals("2023-01-01T00:00:00Z", transformer.toUni(registration).published_at)
    }
}
