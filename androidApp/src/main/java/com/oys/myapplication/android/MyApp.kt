package com.oys.myapplication.android

import android.app.Application
import com.oys.myapplication.di.initKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}