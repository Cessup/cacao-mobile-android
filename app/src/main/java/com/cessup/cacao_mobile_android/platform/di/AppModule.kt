package com.cessup.cacao_mobile_android.platform.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.cessup.cacao_mobile_android.data.UserRepositoryImpl
import com.cessup.cacao_mobile_android.data.source.local.db.AppDatabase
import com.cessup.cacao_mobile_android.data.source.local.db.user.UserDao
import com.cessup.cacao_mobile_android.data.source.local.temp.LocalStorage
import com.cessup.cacao_mobile_android.data.source.local.temp.LocalStorageImpl
import com.cessup.cacao_mobile_android.data.source.remote.ApiClient
import com.cessup.cacao_mobile_android.data.source.remote.ApiService
import com.cessup.cacao_mobile_android.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * AppModule is a class with some modules for injection in this application.
 *
 * @author
 *     Cessup
 * @since 1.0
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * This function provide a local storage.
     */
    @Provides
    @Singleton
    fun provideLocalStorage(@ApplicationContext context: Context): LocalStorage {
        return LocalStorageImpl(context)
    }
    /**
     * This function provide
     */
    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
    }
    /**
     * This function provide
     */
    @Provides @Singleton
    fun provideDataBase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "app.db").build()

    @Provides @Singleton
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()
    /**
     * This function provide
     */
    @Provides
    @Singleton
    fun provideApiService(): ApiService = ApiClient.retrofitInstance
    /**
     * This function provide
     */
    @Provides @Singleton
    fun provideUserRepository(userDao : UserDao, api : ApiService, localStorage : LocalStorage): UserRepository = UserRepositoryImpl(userDao = userDao, api = api, localStorage = localStorage)
}

