package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.JsonClassDiscriminator

@CommonParcelize
@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("type_")
sealed interface ReportCombinedView : DatatypeRoot
