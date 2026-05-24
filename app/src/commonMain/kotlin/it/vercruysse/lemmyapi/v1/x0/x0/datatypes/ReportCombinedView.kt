package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.JsonClassDiscriminator

@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("type_")
internal sealed interface ReportCombinedView
