package com.example.multiplethemedemo.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.multiplethemedemo.utils.AppSharePref
import com.example.multiplethemedemo.MyApplication
import com.example.multiplethemedemo.R
import com.example.multiplethemedemo.utils.matchThem

class ChangeThemeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        matchThem(AppSharePref.themeType)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_theme)

        findViewById<Button>(R.id.btnSelectTheme).setOnClickListener {

            val position = AppSharePref.themeType

            AlertDialog.Builder(this)
                .setTitle("Select Theme")
                .setSingleChoiceItems(resources.getStringArray(R.array.themes), position) { dialog, which ->
                    AppSharePref.themeType = which
                    if (which < 4) {
                        MyApplication.myApplication.onCreate()
                    }
                    startActivity(Intent(this@ChangeThemeActivity, MainActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    })

                    dialog.dismiss()

                }.show()
        }
    }
}
