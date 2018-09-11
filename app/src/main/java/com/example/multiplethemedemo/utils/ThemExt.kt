package com.example.multiplethemedemo.utils

import android.app.Activity
import com.example.multiplethemedemo.R

fun Activity.matchThem(themeType: Int) {
    if (themeType > 3) {
        val themeId = when(themeType) {
            4 -> R.style.AppThemeLightOne
            5 -> R.style.AppThemeLightTwo
            6 -> R.style.AppThemeAMOLED
            else -> R.style.AppThemeLightOne
        }
        setTheme(themeId)
    }
}