package com.cessup.cacao_mobile_android.platform.di

import android.app.Application
import androidx.room.Room
import com.cessup.cacao_mobile_android.data.UserRepositoryImpl
import com.cessup.cacao_mobile_android.data.source.local.db.AppDatabase
import com.cessup.cacao_mobile_android.data.source.local.db.user.UserDao
import com.cessup.cacao_mobile_android.data.source.local.temp.LocalStorage
import com.cessup.cacao_mobile_android.data.source.local.temp.LocalStorageImpl
import com.cessup.cacao_mobile_android.data.source.remote.ApiClient
import com.cessup.cacao_mobile_android.data.source.remote.ApiService
import com.cessup.cacao_mobile_android.domain.repository.UserRepository
import com.cessup.cacao_mobile_android.platform.utils.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * AppModule is a class with some modules for injection in this application.
 *
 * @author
 *     Cessup
 * @since 1.0
 */
@Module
class AppModule(private val application: Application) {
    /**
     * This function provide the router to navigate between views.
     */
    @Provides
    @Singleton
    fun provideRouter(): Router = Router(application)
    /**
     * This function provide a local storage.
     */
    @Provides
    @Singleton
    fun provideLocalStorage(): LocalStorage {
        return LocalStorageImpl(application)
    }
    /**
     * This function provide
     */
    @Provides @Singleton
    fun provideDataBase(): AppDatabase =
        Room.databaseBuilder(application, AppDatabase::class.java, "app.db").build()
    /**
     * This function provide
     */
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

