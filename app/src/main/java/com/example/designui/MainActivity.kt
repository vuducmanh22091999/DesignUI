package com.example.designui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.designui.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment()
    }

    private fun addFragment() {
        supportFragmentManager.beginTransaction().add(R.id.flContentScreen, HomeFragment())
            .addToBackStack(null).commit()
    }
}