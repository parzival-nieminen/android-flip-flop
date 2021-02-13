package com.udacity.shoestore

import android.app.Application
import timber.log.Timber

class ShoestoreApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}