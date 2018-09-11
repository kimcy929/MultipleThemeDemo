package com.example.multiplethemedemo

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.multiplethemedemo.utils.AppSharePref
import com.example.multiplethemedemo.utils.AppSharePref.themeType
import com.example.multiplethemedemo.utils.ThemeType
import timber.log.Timber

class MyApplication : Application() {

    companion object {
        lateinit var myApplication: MyApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()

        myApplication = this

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        AppSharePref.init(this)

        // set theme DayNight else set the normal theme in Activity btw call matchTheme
        if (themeType <= ThemeType.DAY_NIGHT_FLOW_SYSTEM) {
            AppCompatDelegate.setDefaultNightMode(getNightMode(themeType))
        }

        registerActivityLifecycleCallbacks(LifeCycleListener())
    }

    private fun getNightMode(dayNightMode: Int = 0): Int {
        return when (dayNightMode) {
            ThemeType.DAY_NIGHT_AUTO -> AppCompatDelegate.MODE_NIGHT_AUTO
            ThemeType.DAY_NIGHT_LIGHT -> AppCompatDelegate.MODE_NIGHT_NO
            ThemeType.DAY_NIGHT_NIGHT -> AppCompatDelegate.MODE_NIGHT_YES
            ThemeType.DAY_NIGHT_FLOW_SYSTEM -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
            else -> AppCompatDelegate.MODE_NIGHT_AUTO
        }
    }
}