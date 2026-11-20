package it.vercruysse.lemmyapi.utils

import it.vercruysse.lemmyapi.datatypes.CommentView
import it.vercruysse.lemmyapi.datatypes.PostCommentCombinedView
import it.vercruysse.lemmyapi.datatypes.PostView

/**
 * Pre 1.0 Lemmy returns posts and comments as two separate lists, this weaves them into one list,
 * newest published first, like the combined endpoints of 1.0.
 */
internal fun weaveNewestFirst(
    comments: List<CommentView>,
    posts: List<PostView>,
): List<PostCommentCombinedView> = (comments + posts).sortedByDescending { sortableTimestamp(it.publishedAt()) }

private fun PostCommentCombinedView.publishedAt(): String = when (this) {
    is PostView -> post.published_at
    is CommentView -> comment.published_at
}

/**
 * Turns a Lemmy timestamp (`2024-01-02T03:04:05.123456Z`, `2023-01-02T03:04:05.123456`, `...+00:00`)
 * into a string that sorts chronologically: the date and time up to seconds, followed by
 * the fractional seconds padded to nanoseconds. The time zone is ignored, Lemmy always uses UTC.
 */
internal fun sortableTimestamp(timestamp: String): String {
    val seconds = timestamp.take(19)
    val fraction = timestamp.drop(19).takeIf { it.startsWith('.') }?.drop(1)?.takeWhile { it.isDigit() }.orEmpty()
    return seconds + fraction.take(9).padEnd(9, '0')
}
