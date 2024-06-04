package com.example.empower

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SettingsActivity : AppCompatActivity() {

    private lateinit var notificationsSwitch: Switch
    private lateinit var darkModeSwitch: Switch
    private lateinit var languageSpinner: Spinner
    private lateinit var logoutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        notificationsSwitch = findViewById(R.id.notificationsSwitch)
        darkModeSwitch = findViewById(R.id.darkModeSwitch)
        languageSpinner = findViewById(R.id.languageSpinner)
        logoutButton = findViewById(R.id.logoutButton)

        logoutButton.setOnClickListener { logOut() }

        // Load saved settings (if any)
        loadSettings()
    }

    private fun loadSettings() {
        val sharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE)
        notificationsSwitch.isChecked = sharedPreferences.getBoolean("notifications", true)
        darkModeSwitch.isChecked = sharedPreferences.getBoolean("dark_mode", false)
        languageSpinner.setSelection(sharedPreferences.getInt("language", 0))
    }

    private fun saveSettings() {
        val sharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putBoolean("notifications", notificationsSwitch.isChecked)
            putBoolean("dark_mode", darkModeSwitch.isChecked)
            putInt("language", languageSpinner.selectedItemPosition)
            apply()
        }
    }

    private fun logOut() {
        // Sign out from Firebase
        FirebaseAuth.getInstance().signOut()

        // Remove saved credentials
        val sharedPreferences = getSharedPreferences("userPrefs", Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            remove("email")
            remove("password")
            apply()
        }

        // Navigate to LoginActivity
        val intent = Intent(this, Login::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

    override fun onPause() {
        super.onPause()
        saveSettings()
    }
}
