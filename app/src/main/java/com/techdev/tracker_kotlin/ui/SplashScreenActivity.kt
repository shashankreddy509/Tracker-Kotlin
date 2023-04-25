package com.techdev.tracker_kotlin.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.techdev.tracker_kotlin.databinding.ActivityMainBinding
import com.techdev.tracker_kotlin.ui.auth.login.LoginActivity
import com.techdev.tracker_kotlin.ui.dashboard.DashboardActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.seconds

@AndroidEntryPoint
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        runBlocking {
            delay(2.seconds)
            val intent = if (auth.currentUser != null) {
                Intent(this@SplashScreenActivity, DashboardActivity::class.java)
            } else {
                Intent(this@SplashScreenActivity, LoginActivity::class.java)
            }
            startActivity(intent)
            finish()
        }
    }
}
