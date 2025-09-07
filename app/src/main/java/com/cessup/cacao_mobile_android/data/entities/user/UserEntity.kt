package com.cessup.cacao_mobile_android.data.entities.user

/**
 * Represents a user.
 *
 * @property id unique identifier
 * @property email the email the user belongs to
 * @property phone the phone of the user for account
 * @property password the password of the user for account
 * @property details All information about this user
 */
data class UserEntity(
    val id: String,
    val email: String,
    val phone: String,
    val password: String,
    val nickName: String,
    val details: UserDetailsEntity
)