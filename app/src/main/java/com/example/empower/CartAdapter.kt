package com.example.empower

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartAdapter(private val cartItems: MutableList<CartItem>, private val onItemRemoved: () -> Unit) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.itemName)
        val itemPrice: TextView = itemView.findViewById(R.id.itemPrice)
        val removeItemButton: Button = itemView.findViewById(R.id.removeItemButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = cartItems[position]
        holder.itemName.text = item.name
        holder.itemPrice.text = "R${item.price}"

        holder.removeItemButton.setOnClickListener {
            CartManager.removeItem(item)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, cartItems.size)
            onItemRemoved()
        }
    }

    override fun getItemCount() = cartItems.size
}




