import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.descriptors.PolymorphicKind
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.SerialKind
import kotlinx.serialization.descriptors.StructureKind
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

// Builds minimal JSON samples from serializer descriptors, for mocking server responses in tests.

@OptIn(ExperimentalSerializationApi::class)
internal fun SerialDescriptor.element(name: String): SerialDescriptor = getElementDescriptor(getElementIndex(name))

@OptIn(ExperimentalSerializationApi::class)
internal fun objectWith(descriptor: SerialDescriptor, vararg fields: Pair<String, JsonElement>): JsonObject =
    JsonObject((sample(descriptor) as JsonObject) + fields)

@OptIn(ExperimentalSerializationApi::class)
internal fun sample(descriptor: SerialDescriptor, nullable: Boolean = true): JsonElement {
    if (nullable && descriptor.isNullable) return JsonNull
    return when (descriptor.kind) {
        PrimitiveKind.BOOLEAN -> JsonPrimitive(false)

        PrimitiveKind.STRING, PrimitiveKind.CHAR -> JsonPrimitive("test")

        PrimitiveKind.BYTE, PrimitiveKind.SHORT, PrimitiveKind.INT, PrimitiveKind.LONG,
        PrimitiveKind.FLOAT, PrimitiveKind.DOUBLE,
        -> JsonPrimitive(1)

        SerialKind.ENUM -> JsonPrimitive(descriptor.getElementName(0))

        StructureKind.LIST -> JsonArray(emptyList())

        StructureKind.CLASS, StructureKind.OBJECT -> JsonObject(
            (0 until descriptor.elementsCount)
                .filterNot(descriptor::isElementOptional)
                .associate { descriptor.getElementName(it) to sample(descriptor.getElementDescriptor(it)) },
        )

        is PolymorphicKind -> error("Unexpected polymorphic field ${descriptor.serialName}")

        else -> error("Unexpected field ${descriptor.serialName}")
    }
}
