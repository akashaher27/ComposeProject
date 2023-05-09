package com.example.home.ui.dashboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

const val TAG = "HomeActivity"

class HomeActivity : AppCompatActivity() {

    companion object {
        fun intent(context: Context) = Intent(
            context,
            HomeActivity::class.java
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
    }
}