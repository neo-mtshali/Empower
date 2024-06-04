package com.example.empower

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog

class PaymentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_details)

        val cartItems = CartManager.cartItems
        val totalAmount = intent.getIntExtra("totalAmount", 0)
        val discountAmount = intent.getIntExtra("discountAmount", 0)

        val paymentDetailsLayout = findViewById<LinearLayout>(R.id.paymentDetailsLayout)

        cartItems.forEach { item ->
            val itemTextView = TextView(this)
            itemTextView.text = "${item.name} (R${item.price})"
            itemTextView.textSize = 14f
            paymentDetailsLayout.addView(itemTextView)
        }


        val discountTextView = TextView(this)
        discountTextView.text = "Discount: -R$discountAmount"
        discountTextView.textSize = 14f
        paymentDetailsLayout.addView(discountTextView)

        val totalTextView = TextView(this)
        totalTextView.text = "Total: R$totalAmount"
        totalTextView.textSize = 16f
        totalTextView.setPadding(0, 16, 0, 0)
        totalTextView.setTextColor(resources.getColor(android.R.color.black))
        paymentDetailsLayout.addView(totalTextView)

        findViewById<TextView>(R.id.addPaymentMethodButton).setOnClickListener {
            showAddPaymentMethodBottomSheet()
        }
    }

    private fun showAddPaymentMethodBottomSheet() {
        val bottomSheetDialog = BottomSheetDialog(this)
        val bottomSheetView = layoutInflater.inflate(R.layout.bottom_sheet_add_payment_method, null)
        bottomSheetDialog.setContentView(bottomSheetView)
        bottomSheetDialog.show()
    }
}


