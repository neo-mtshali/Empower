package com.example.empower

object CartManager {
    val cartItems = mutableListOf<CartItem>()

    fun addItem(item: CartItem) {
        cartItems.add(item)
    }

    fun removeItem(item: CartItem) {
        cartItems.remove(item)
    }

    fun calculateTotal(): Pair<Int, Int> {
        var total = 0
        cartItems.forEach { total += it.price }

        // Apply discount based on number of courses
        val discount = when (cartItems.size) {
            1 -> 0.0
            2 -> 0.05
            3 -> 0.10
            else -> 0.15
        }

        val discountAmount = (total * discount).toInt()
        val finalTotal = total - discountAmount

        return Pair(finalTotal, discountAmount)
    }
}

