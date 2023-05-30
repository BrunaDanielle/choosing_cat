package com.example.choosingcat.common

import android.app.Application
import com.example.choosingcat.common.di.ApplicationModule
import com.example.choosingcat.randomcat.di.randomCatDataModule
import com.example.choosingcat.randomcat.di.randomCatNetworkModule
import com.example.choosingcat.randomcat.di.randomCatPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                randomCatPresentationModule
                        + randomCatNetworkModule
                        + randomCatDataModule
                        + ApplicationModule.networkModule
            )
        }
    }
}