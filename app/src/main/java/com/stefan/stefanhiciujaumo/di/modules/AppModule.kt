package com.stefan.stefanhiciujaumo.di.modules

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun getContext(context: Application): Context
}