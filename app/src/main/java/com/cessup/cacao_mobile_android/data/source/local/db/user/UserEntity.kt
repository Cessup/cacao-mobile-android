package com.cessup.cacao_mobile_android.data.source.local.db.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    val username: String
)