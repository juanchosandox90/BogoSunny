package com.sandoval.bogosunny.di.component

import com.sandoval.bogosunny.BogoSunnyApplication
import com.sandoval.bogosunny.di.module.ActivityBindingModule
import com.sandoval.bogosunny.di.module.ApplicationModule
import com.sandoval.bogosunny.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        ActivityBindingModule::class,
        ViewModelModule::class
        //TODO: NetworkModule,
    ]
)
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(bogoSunnyApplication: BogoSunnyApplication): Builder

        fun build(): ApplicationComponent
    }

    fun inject(bogoSunnyApplication: BogoSunnyApplication)
}