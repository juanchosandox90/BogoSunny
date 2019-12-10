package com.sandoval.bogosunny.di.module

import android.app.Application
import android.content.Context
import com.sandoval.bogosunny.BogoSunnyApplication
import com.sandoval.bogosunny.di.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    //TODO: Add eventually all the providers that will interact in the app: Api, DB, Room, DataManager, BaseUrl, RXComposite-disposable

    @Provides
    @ApplicationContext
    internal fun provideContext(bogoSunnyApplication: BogoSunnyApplication): Context {
        return bogoSunnyApplication.applicationContext
    }

    @Provides
    internal fun provideApplication(bogoSunnyApplication: BogoSunnyApplication): Application {
        return bogoSunnyApplication
    }
}