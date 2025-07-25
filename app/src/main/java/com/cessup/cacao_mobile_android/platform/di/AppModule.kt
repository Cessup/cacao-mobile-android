package com.cessup.cacao_mobile_android.platform.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.cessup.cacao_mobile_android.data.UserRepositoryImpl
import com.cessup.cacao_mobile_android.data.source.local.db.AppDatabase
import com.cessup.cacao_mobile_android.data.source.local.db.user.UserDao
import com.cessup.cacao_mobile_android.data.source.remote.ApiClient
import com.cessup.cacao_mobile_android.data.source.remote.ApiService
import com.cessup.cacao_mobile_android.domain.repository.UserRepository
import com.cessup.cacao_mobile_android.platform.utils.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {
    @Provides
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun provideRouter(): Router = Router(application)

    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences {
        return application.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
    }

    @Provides @Singleton
    fun provideDataBase(): AppDatabase =
        Room.databaseBuilder(application, AppDatabase::class.java, "app.db").build()

    @Provides @Singleton
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()

    @Provides
    @Singleton
    fun provideApiService(): ApiService = ApiClient.retrofitInstance

    @Provides @Singleton
    fun provideUserRepository(userDao : UserDao, api : ApiService): UserRepository = UserRepositoryImpl(userDao = userDao, api = api)
}

