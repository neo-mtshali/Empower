package com.example.empower

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HmSc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hm_sc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCourse = findViewById<ImageButton>(R.id.btnCourse)
        btnCourse.setOnClickListener {
            val intent = Intent(this, Lesson::class.java)
            startActivity(intent)
        }

        val btnProfile = findViewById<ImageButton>(R.id.btnProfile)
        btnProfile.setOnClickListener {
            val intent = Intent(this, Account::class.java)
            startActivity(intent)
        }
    }
}