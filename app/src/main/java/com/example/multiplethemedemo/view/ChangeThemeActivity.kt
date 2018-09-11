package com.example.multiplethemedemo.view

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.multiplethemedemo.MyApplication
import com.example.multiplethemedemo.R
import com.example.multiplethemedemo.utils.AppSharePref
import com.example.multiplethemedemo.utils.ThemeType
import com.example.multiplethemedemo.utils.matchThem

class ChangeThemeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        matchThem(AppSharePref.themeType)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_theme)

        findViewById<Button>(R.id.btnSelectTheme).setOnClickListener {

            val position = AppSharePref.themeType

            AlertDialog.Builder(this)
                .setTitle(R.string.select_theme)
                .setSingleChoiceItems(resources.getStringArray(R.array.themes), position) { dialog, which ->
                    if (which != AppSharePref.themeType) {
                        AppSharePref.themeType = which
                        if (which <= ThemeType.DAY_NIGHT_FLOW_SYSTEM) {
                            MyApplication.myApplication.onCreate()
                        }
                        recreate()
                    }
                    dialog.dismiss()

                }.show()
        }
    }
}
