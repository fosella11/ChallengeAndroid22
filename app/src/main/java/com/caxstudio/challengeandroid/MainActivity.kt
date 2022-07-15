package com.caxstudio.challengeandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        val navController = findNavController(R.id.nav_host)
        if (navController.currentDestination?.id == R.id.characterFragment) {
            finish()
        } else {
            super.onBackPressed()
        }
    }
}