package com.example.empower

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        nameEditText = findViewById(R.id.nameEditText)
        ageEditText = findViewById(R.id.ageEditText)
        saveButton = findViewById(R.id.saveButton)

        saveButton.setOnClickListener { onSaveProfile() }
    }

    private fun onSaveProfile() {
        val name = nameEditText.text.toString()
        val age = ageEditText.text.toString().toIntOrNull()

        if (name.isEmpty() || age == null) {
            Toast.makeText(this, "Please enter valid details", Toast.LENGTH_SHORT).show()
            return
        }

        // Save profile information
        // Here, you can save the information to your database or shared preferences

        Toast.makeText(this, "Profile updated", Toast.LENGTH_SHORT).show()
    }
}

