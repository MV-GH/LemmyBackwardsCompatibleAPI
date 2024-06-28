package it.vercruysse.lemmyapi

/**
 * This declares a property to compare the identity of two objects of the same type
 *
 * This is useful to create to define uniqueness when the other fields can be different
 */
interface Identity {
    val id: Long
}
