package com.example.multiplethemedemo.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

object AppSharePref {

    private const val PREFS_KEY = "com.example.multiple_theme_demo"
    private const val THEME_TYPE = "theme_type"

    lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
    }

    var themeType: Int
        get() = sharedPreferences.getInt(THEME_TYPE, 0)
        set(value) {
            sharedPreferences.edit {
                putInt(THEME_TYPE, value)
            }
        }
}