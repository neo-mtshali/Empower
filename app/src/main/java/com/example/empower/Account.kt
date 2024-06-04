package com.example.empower

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Account : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_account)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnHmSc = findViewById<ImageButton>(R.id.btnHome)
        btnHmSc.setOnClickListener {
            val intent = Intent(this, HmSc::class.java)
            startActivity(intent)
        }

        val btnCourse = findViewById<ImageButton>(R.id.btnCourse)
        btnCourse.setOnClickListener {
            val intent = Intent(this, Lesson::class.java)
            startActivity(intent)
        }

        val cartCardView = findViewById<CardView>(R.id.cartCardView)
        cartCardView.setOnClickListener {
            val intent = Intent(this, Cart::class.java)
            startActivity(intent)
        }

        val contactCardView = findViewById<CardView>(R.id.contactCardView)
        contactCardView.setOnClickListener {
            val intent = Intent(this, Contact::class.java)
            startActivity(intent)
        }

        val profileCardView = findViewById<CardView>(R.id.profileCardView)
        profileCardView.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        val settingsCardView = findViewById<CardView>(R.id.settingsCardView)
        settingsCardView.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}

