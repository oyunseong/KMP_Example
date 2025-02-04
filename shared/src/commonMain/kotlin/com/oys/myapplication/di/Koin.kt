package com.oys.myapplication.di

import com.oys.myapplication.screens.home.HomeViewModel
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    factoryOf(::HomeViewModel)
}

fun initKoin() {
    startKoin {
        modules(
            viewModelModule,
        )
    }
}
