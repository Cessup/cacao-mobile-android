package com.cessup.cacao_mobile_android.platform.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.cessup.cacao_mobile_android.data.DrinkRepositoryImpl
import com.cessup.cacao_mobile_android.data.MealRepositoryImpl
import com.cessup.cacao_mobile_android.data.UserRepositoryImpl
import com.cessup.cacao_mobile_android.data.source.local.db.AppDatabase
import com.cessup.cacao_mobile_android.data.source.local.db.user.UserDao
import com.cessup.cacao_mobile_android.data.source.remote.ApiClient
import com.cessup.cacao_mobile_android.data.source.remote.DrinkService
import com.cessup.cacao_mobile_android.data.source.remote.MealService
import com.cessup.cacao_mobile_android.data.source.remote.UserService
import com.cessup.cacao_mobile_android.domain.repository.UserRepository
import com.cessup.cacao_mobile_android.platform.utils.Router
import com.cessup.domain.repositories.eatable.DrinkRepository
import com.cessup.domain.repositories.eatable.MealRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
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
    fun provideApiService(): Retrofit = ApiClient.retrofitInstance

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserService =
        retrofit.create(UserService::class.java)

    @Provides
    @Singleton
    fun provideDrinkService(retrofit: Retrofit): DrinkService =
        retrofit.create(DrinkService::class.java)

    @Provides
    @Singleton
    fun provideMealService(retrofit: Retrofit): MealService =
        retrofit.create(MealService::class.java)

    @Provides @Singleton
    fun provideUserRepository(userDao : UserDao, api : UserService): UserRepository = UserRepositoryImpl(userDao = userDao, api = api)

    @Provides @Singleton
    fun provideDrinkRepository(drinkService : DrinkService): DrinkRepository = DrinkRepositoryImpl(api = drinkService)

    @Provides @Singleton
    fun provideMealRepository(mealService : MealService): MealRepository = MealRepositoryImpl(api = mealService)
}

