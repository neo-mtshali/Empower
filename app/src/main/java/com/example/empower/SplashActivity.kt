package com.example.empower

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.empower.HmSc
import com.example.empower.Login
import com.example.empower.R
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Initialize Firebase
        FirebaseApp.initializeApp(this)

        // Check user authentication status
        val user = FirebaseAuth.getInstance().currentUser

        // Delay for splash screen visibility
        val splashTimeOut: Long = 3000 // 3 seconds
        Handler().postDelayed({
            if (user != null) {
                // User is signed in, navigate to HomeActivity
                startActivity(Intent(this, HmSc::class.java))
            } else {
                // User is not signed in, navigate to Main::class.java
                startActivity(Intent(this, MainActivity::class.java))
            }
            // Close SplashActivity
            finish()
        }, splashTimeOut)
    }
}


