package com.cessup.cacao_mobile_android.platform.di

import android.content.Context
import androidx.room.Room
import com.cessup.cacao_mobile_android.data.DrinkRepositoryImpl
import com.cessup.cacao_mobile_android.data.MealRepositoryImpl
import com.cessup.cacao_mobile_android.data.UserRepositoryImpl
import com.cessup.cacao_mobile_android.data.source.local.db.AppDatabase
import com.cessup.cacao_mobile_android.data.source.local.db.user.UserDao
import com.cessup.cacao_mobile_android.data.source.local.temp.LocalStorage
import com.cessup.cacao_mobile_android.data.source.local.temp.LocalStorageImpl
import com.cessup.cacao_mobile_android.data.source.remote.ApiClient
import com.cessup.cacao_mobile_android.data.source.remote.DrinkService
import com.cessup.cacao_mobile_android.data.source.remote.MealService
import com.cessup.cacao_mobile_android.data.source.remote.UserService
import com.cessup.cacao_mobile_android.domain.repository.UserRepository
import com.cessup.domain.repositories.eatable.DrinkRepository
import com.cessup.domain.repositories.eatable.MealRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
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
     * This function provide a local storage by SharedPreferences
     *
     * @param context that is context from application
     * @return LocalStorage is an interface about save some values in a Local Storage
     */
    @Provides
    @Singleton
    fun provideLocalStorage(@ApplicationContext context: Context): LocalStorage {
        return LocalStorageImpl(context)
    }
    /**
     * This function provide AppDataBase by RoomDataBase
     *
     * @param context that is context from application
     * @return AppDataBase is an interface about save some values in a Local Storage
     *
     */
    @Provides @Singleton
    fun provideDataBase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "app.db").build()
    /**
     * This function provide UserDAO
     *
     * @param db that is an instance of AppDataBase
     * @return UserDao it is an interface about user table in the database.
     */
    @Provides @Singleton
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()
    /**
     * This function provide Retrofit connection
     *
     * @param context that is context from application
     * @return Retrofit it is an interface to connect to internet
     *
     */
    @Provides
    @Singleton
    fun provideApiService(@ApplicationContext context: Context): Retrofit = ApiClient.getInstance(context)
    /**
     * This function provide UserService
     *
     * @param retrofit that is context from application
     * @return UserService contain all user services
     */
    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserService =
        retrofit.create(UserService::class.java)
    /**
     * This function provide DrinkService
     *
     * @param retrofit that is context from application
     * @return DrinkService contain all drink services
     */
    @Provides
    @Singleton
    fun provideDrinkService(retrofit: Retrofit): DrinkService =
        retrofit.create(DrinkService::class.java)
    /**
     * This function provide MealService
     *
     * @param retrofit that is context from application
     * @return MealService contain all meal services
     */
    @Provides
    @Singleton
    fun provideMealService(retrofit: Retrofit): MealService =
        retrofit.create(MealService::class.java)
    /**
     * This function provide User Repository
     *
     * @param userDao it is an interface about user table in the database
     * @param userServices there are all user services
     * @param localStorage that can save some temp values
     * @return UserRepository contain all user services
     */
    @Provides @Singleton
    fun provideUserRepository(userDao : UserDao, userServices : UserService, localStorage: LocalStorage): UserRepository = UserRepositoryImpl(userDao = userDao, api = userServices, localStorage = localStorage)
    /**
     * This function provide Drink Repository
     *
     * @param drinkService there are all drink services
     * @return UserRepository contain all drink services
     */
    @Provides @Singleton
    fun provideDrinkRepository(drinkService : DrinkService): DrinkRepository =
        DrinkRepositoryImpl(api = drinkService)
    /**
     * This function provide Meal Repository
     *
     * @param mealService there are all meal services
     * @return MealRepository contain all meal services
     */
    @Provides @Singleton
    fun provideMealRepository(mealService : MealService): MealRepository =
        MealRepositoryImpl(api = mealService)
}

