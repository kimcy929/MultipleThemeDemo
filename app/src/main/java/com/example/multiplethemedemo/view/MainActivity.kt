package com.example.multiplethemedemo.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.multiplethemedemo.R
import com.example.multiplethemedemo.utils.AppSharePref
import com.example.multiplethemedemo.utils.matchThem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        matchThem(AppSharePref.themeType)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnChangeTheme).setOnClickListener {
            startActivity(Intent(application, ChangeThemeActivity::class.java))
        }
    }
}
