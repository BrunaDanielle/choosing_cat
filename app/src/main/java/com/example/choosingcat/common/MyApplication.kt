package com.example.choosingcat.common

import android.app.Application
import com.example.choosingcat.common.di.ApplicationModule.networkModule
import com.example.choosingcat.common.data.local.di.CatDataModule.catDataModule
import com.example.choosingcat.randomcat.di.randomCatDataModule
import com.example.choosingcat.randomcat.di.randomCatNetworkModule
import com.example.choosingcat.randomcat.di.randomCatPresentationModule
import com.example.choosingcat.savedcats.di.savedCatsDataModule
import com.example.choosingcat.savedcats.di.savedCatsPresentationModule
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
                        + catDataModule
                        + networkModule
                        + savedCatsDataModule
                        + savedCatsPresentationModule
            )
        }
    }
}