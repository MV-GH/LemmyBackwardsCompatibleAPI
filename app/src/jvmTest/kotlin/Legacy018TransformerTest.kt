import it.vercruysse.lemmyapi.IGNORE_UNKNOWN_KEYS_JSON
import it.vercruysse.lemmyapi.v0.x18.x5.Transformer
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlin.test.Test
import kotlin.test.assertTrue
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.LocalUserView as X5LocalUserView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PersonView as X5PersonView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PostView as X5PostView

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
}
