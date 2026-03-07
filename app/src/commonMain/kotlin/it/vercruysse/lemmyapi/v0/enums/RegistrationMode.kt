package it.vercruysse.lemmyapi.v0.enums

import it.vercruysse.lemmyapi.enums.RegistrationMode as UniRegistrationMode
import kotlinx.serialization.Serializable

@Serializable
internal enum class RegistrationMode {
    Closed,
    RequireApplication,
    Open,
    ;

    fun toUni(): UniRegistrationMode =
        when (this) {
            Closed -> UniRegistrationMode.Closed
            RequireApplication -> UniRegistrationMode.RequireApplication
            Open -> UniRegistrationMode.Open
        }

    companion object {
        fun fromUniNullable(uni: UniRegistrationMode?): RegistrationMode? =
            when (uni) {
                null -> null
                UniRegistrationMode.Closed -> Closed
                UniRegistrationMode.RequireApplication -> RequireApplication
                UniRegistrationMode.Open -> Open
            }

        fun fromUni(uni: UniRegistrationMode): RegistrationMode = fromUniNullable(uni) ?: error("No v0 mapping for $uni")
    }
}

internal fun RegistrationMode?.toUni(): UniRegistrationMode? = this?.toUni()
