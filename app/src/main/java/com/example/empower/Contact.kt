package com.example.empower

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Contact : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        val instagramButton = findViewById<ImageButton>(R.id.instagramButton)
        instagramButton.setOnClickListener {
            openWebsite("https://www.instagram.com")
        }

        val xButton = findViewById<ImageButton>(R.id.xButton)
        xButton.setOnClickListener {
            openWebsite("https://www.x.com")
        }

        val facebookButton = findViewById<ImageButton>(R.id.facebookButton)
        facebookButton.setOnClickListener {
            openWebsite("https://www.facebook.com")
        }
    }

    private fun openWebsite(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}
