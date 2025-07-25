package com.cessup.cacao_mobile_android.data.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cessup.cacao_mobile_android.data.source.local.db.user.UserEntity
import com.cessup.cacao_mobile_android.data.source.local.db.user.UserDao

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}