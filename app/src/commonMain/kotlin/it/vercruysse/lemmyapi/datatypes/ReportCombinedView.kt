package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.JsonClassDiscriminator

@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("type_")
sealed interface ReportCombinedView : DatatypeRoot
