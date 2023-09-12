package com.plcoding.contactscomposemultiplatform.android

import android.app.Application
import com.plcoding.contactscomposemultiplatform.di.apiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}