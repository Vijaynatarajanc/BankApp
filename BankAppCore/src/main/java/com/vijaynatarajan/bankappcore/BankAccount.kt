package com.vijaynatarajan.bankappcore

data class BankAccount(
    var account_customer_id: Int,
    val account_number: Int,
    var account_type: String,
    var account_balance: Double,
    var customer: Customer
)