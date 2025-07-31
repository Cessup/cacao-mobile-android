package com.cessup.cacao_mobile_android.data.source.local.db.user

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents a user.
 *
 * @property uid unique identifier
 * @property email the email the user belongs to
 * @property phone the phone of the user for account
 * @property password the password of the user for account
 * @property idDetails All information about this user
 */
@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,
    val email: String,
    val phone: String,
    val password: String,
    val nickname: String,
    val idDetails: String
)