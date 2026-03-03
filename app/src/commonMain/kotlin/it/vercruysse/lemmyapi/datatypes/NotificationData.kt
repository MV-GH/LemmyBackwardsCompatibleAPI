package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
//import it.vercruysse.lemmyapi.serializers.NotificationDataSerializer
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

// TODO: uses custom serializers, idk if better solution, also maybe move to combined types

@CommonParcelize
//@Serializable(with = NotificationDataSerializer::class)
@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("type_")
sealed interface NotificationData : DatatypeRoot {
//    @CommonParcelize
//    @Serializable
//    data class Post(
//        val post: PostView
//    ) : NotificationData()
//
//    @CommonParcelize
//    @Serializable
//    data class Comment(
//        val comment: CommentView
//    ) : NotificationData()
//
//    @CommonParcelize
//    @Serializable
//    data class PrivateMessage(
//        val private_message: PrivateMessageView
//    ) : NotificationData()
//
//    @CommonParcelize
//    @Serializable
//    data class ModAction(
//        val mod_action: ModlogView
//    ) : NotificationData()
}



