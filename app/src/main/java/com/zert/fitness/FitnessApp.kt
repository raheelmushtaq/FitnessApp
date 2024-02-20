package com.zert.fitness

import android.app.Application
import androidx.multidex.MultiDex
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FitnessApp :Application(){
    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)

    }
}