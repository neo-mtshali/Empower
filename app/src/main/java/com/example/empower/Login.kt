package com.example.empower

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException

class Login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize Firebase Authentication
        auth = FirebaseAuth.getInstance()

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val forgotPasswordText = findViewById<TextView>(R.id.forgotPasswordText)
        val createAccountText = findViewById<TextView>(R.id.createAccountText)

        // Login Button Click Listener
        loginButton.setOnClickListener {
            val email = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                loginUser(email, password)
            } else {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }
        }

        // Forgot Password Text Click Listener
        forgotPasswordText.setOnClickListener {
            val intent = Intent(this, ForgotPass::class.java)
            startActivity(intent)
        }

        // Create Account Text Click Listener
        createAccountText.setOnClickListener {
            val intent = Intent(this, Create::class.java)
            startActivity(intent)
        }
    }

    // Function to login user using Firebase Authentication
    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Navigate to HomeActivity
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    navigateToHome()
                } else {
                    try {
                        throw task.exception!!
                    } catch (e: FirebaseAuthInvalidUserException) {
                        Toast.makeText(this, "Invalid Email Address", Toast.LENGTH_SHORT).show()
                    } catch (e: FirebaseAuthInvalidCredentialsException) {
                        Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show()
                    } catch (e: Exception) {
                        Toast.makeText(this, "Authentication Failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
    }

    // Function to navigate to HomeActivity
    private fun navigateToHome() {
        val intent = Intent(this, HmSc::class.java)
        startActivity(intent)
        finish()
    }
}



