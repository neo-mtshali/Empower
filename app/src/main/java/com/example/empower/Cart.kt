package com.example.empower

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Cart : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var cartAdapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cart)
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

        val btnProfile = findViewById<ImageButton>(R.id.btnProfile)
        btnProfile.setOnClickListener {
            val intent = Intent(this, Account::class.java)
            startActivity(intent)
        }

        recyclerView = findViewById(R.id.recyclerView)
        cartAdapter = CartAdapter(CartManager.cartItems) {
            calculateTotal()
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = cartAdapter

        calculateTotal()

        val buyButton = findViewById<Button>(R.id.buyButton)
        buyButton.setOnClickListener {
            val (total, discountAmount) = CartManager.calculateTotal()
            val intent = Intent(this, PaymentDetailsActivity::class.java)
            intent.putExtra("totalAmount", total)
            intent.putExtra("discountAmount", discountAmount)
            startActivity(intent)
        }
    }

    private fun calculateTotal() {
        val (total, discountAmount) = CartManager.calculateTotal()
        findViewById<TextView>(R.id.totalTextView).text = "Total: R$total"
        findViewById<TextView>(R.id.discountTextView).text = "Discount: -R$discountAmount"
    }
}




