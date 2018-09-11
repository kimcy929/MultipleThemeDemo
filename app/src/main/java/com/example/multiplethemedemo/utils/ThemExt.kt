package com.example.multiplethemedemo.utils

import android.app.Activity
import com.example.multiplethemedemo.R
import kotlin.reflect.KClass

var activities = mutableMapOf<KClass<out Activity>, Int>()

var Activity.themeType: Int
    get() = 0
    set(value) {
    activities[this::class] = value
}

fun Activity.matchThem(themeType: Int) {
    this.themeType = themeType

    if (themeType > ThemeType.DAY_NIGHT_FLOW_SYSTEM) {
        val themeId = when (themeType) {
            ThemeType.LIGHT_ONE -> R.style.AppThemeLightOne

            ThemeType.LIGHT_TWO -> R.style.AppThemeLightTwo

            ThemeType.AMOLED -> R.style.AppThemeAMOLED

            else -> R.style.AppThemeLightOne
        }
        setTheme(themeId)
    }
}

object ThemeType {
    const val DAY_NIGHT_AUTO = 0
    const val DAY_NIGHT_LIGHT = 1
    const val DAY_NIGHT_NIGHT = 2
    const val DAY_NIGHT_FLOW_SYSTEM = 3
    const val LIGHT_ONE = 4
    const val LIGHT_TWO = 5
    const val AMOLED = 6
}