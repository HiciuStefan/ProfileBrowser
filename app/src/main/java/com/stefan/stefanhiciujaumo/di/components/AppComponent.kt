package com.hypnoweb.hypnowebapp.di.components

import android.app.Application
import com.stefan.stefanhiciujaumo.ProfileBrowserApp
import com.stefan.stefanhiciujaumo.di.modules.AppModule
import com.stefan.stefanhiciujaumo.di.modules.ContributeActivityModule
import com.stefan.stefanhiciujaumo.di.modules.NetworkModule
import com.stefan.stefanhiciujaumo.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Component(modules = [
AndroidSupportInjectionModule::class,
AppModule::class,
ContributeActivityModule::class,
ViewModelModule::class,
NetworkModule::class
])

@Singleton
interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(application: DaggerApplication?)
    fun inject(profileBrowserApp: ProfileBrowserApp)

}