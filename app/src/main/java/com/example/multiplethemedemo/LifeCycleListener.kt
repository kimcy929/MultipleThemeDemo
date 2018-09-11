package com.example.multiplethemedemo

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.example.multiplethemedemo.utils.AppSharePref
import com.example.multiplethemedemo.utils.activities
import com.example.multiplethemedemo.utils.themeType

class LifeCycleListener : Application.ActivityLifecycleCallbacks {

    override fun onActivityResumed(activity: Activity) {
        val currThemeType = activities[activity::class] ?: return
        val themeType = AppSharePref.themeType
        if (currThemeType != themeType) {
            activity.themeType = themeType // Avoid recursive call recreate
            activity.recreate()
        }
    }

    override fun onActivityPaused(activity: Activity?) {

    }

    override fun onActivityStarted(activity: Activity?) {

    }

    override fun onActivityDestroyed(activity: Activity?) {

    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {

    }

    override fun onActivityStopped(activity: Activity?) {

    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {

    }
}