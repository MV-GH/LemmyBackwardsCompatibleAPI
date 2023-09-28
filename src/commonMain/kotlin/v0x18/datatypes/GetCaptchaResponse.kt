package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetCaptchaResponse(
    val ok: CaptchaResponse? = null,
)
