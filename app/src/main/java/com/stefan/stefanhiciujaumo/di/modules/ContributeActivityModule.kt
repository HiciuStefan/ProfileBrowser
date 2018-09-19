package com.stefan.stefanhiciujaumo.di.modules

import dagger.Module

/**
 * Created by stefan on 9/18/2018.
 */
@Module(includes = [
CatalogActivityModule::class,
ProfileActivityModule::class
])
internal abstract class ContributeActivityModule {

}