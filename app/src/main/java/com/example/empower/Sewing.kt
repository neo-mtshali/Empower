package com.example.empower

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Sewing : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sewing)
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


        val btnProfile = findViewById<ImageButton>(R.id.btnProfile)
        btnProfile.setOnClickListener {
            val intent = Intent(this, Account::class.java)
            startActivity(intent)
        }

        val btnCourse = findViewById<ImageButton>(R.id.btnCourse)
        btnCourse.setOnClickListener {
            val intent = Intent(this, Lesson::class.java)
            startActivity(intent)
        }

        val addBtn = findViewById<Button>(R.id.Addbtn)
        addBtn.setOnClickListener {
            CartManager.addItem(CartItem("Sewing", 1500))
            val intent = Intent(this, Cart::class.java)
            startActivity(intent)
    }
}
}