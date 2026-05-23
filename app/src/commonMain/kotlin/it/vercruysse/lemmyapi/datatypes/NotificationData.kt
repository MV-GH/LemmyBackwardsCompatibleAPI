package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
//import it.vercruysse.lemmyapi.serializers.NotificationDataSerializer
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator


@CommonParcelize
@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("type_")
sealed interface NotificationData : DatatypeRoot



