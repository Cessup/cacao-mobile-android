package com.cessup.cacao_mobile_android

import android.app.Application
import com.cessup.cacao_mobile_android.platform.di.AppComponent
import com.cessup.cacao_mobile_android.platform.di.AppModule
import com.cessup.cacao_mobile_android.platform.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}