package it.vercruysse.lemmyapi.enums

import kotlinx.serialization.Serializable

@Serializable
enum class VoteAction(val value: Int) {
    UpVote(1),
    DownVote(-1),
    NoVote(0),
    ;

    companion object {
        fun from(value: Int): VoteAction = when (value) {
            1 -> UpVote
            -1 -> DownVote
            0 -> NoVote
            else -> throw IllegalArgumentException("Invalid vote action value: $value")
        }
    }
}
