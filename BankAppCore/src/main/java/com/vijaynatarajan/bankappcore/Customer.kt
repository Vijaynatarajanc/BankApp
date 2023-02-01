package com.vijaynatarajan.bankappcore

class Customer(
    var address: String,
    val accountNumber: String,
    var accountType: String,
    var password: String, id: Long, name: String
) : Entity(id, name) {

    fun addAmount() {
        
    }
}