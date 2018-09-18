package com.stefan.stefanhiciujaumo.di.modules

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun getContext(context: Application): Context

}