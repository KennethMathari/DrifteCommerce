package com.example.driftecommerce

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DriftApplication: Application(){
    override fun onCreate() {
        super.onCreate()

    }

}