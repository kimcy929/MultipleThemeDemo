package com.example.multiplethemedemo

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.multiplethemedemo.utils.AppSharePref
import com.example.multiplethemedemo.utils.AppSharePref.themeType

class MyApplication : Application() {

    companion object {
        lateinit var myApplication: MyApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()

        myApplication = this

        AppSharePref.init(this)

        if (themeType < 4) {
            AppCompatDelegate.setDefaultNightMode(getNightMode(themeType))
        }
    }

    private fun getNightMode(mode: Int = 0): Int {
        return when (mode) {
            0 -> AppCompatDelegate.MODE_NIGHT_AUTO
            1 -> AppCompatDelegate.MODE_NIGHT_NO
            2 -> AppCompatDelegate.MODE_NIGHT_YES
            3 -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
            else -> AppCompatDelegate.MODE_NIGHT_AUTO
        }
    }
}