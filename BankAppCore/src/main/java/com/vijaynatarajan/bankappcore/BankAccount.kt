package com.vijaynatarajan.bankappcore

data class BankAccount(
    var customerId: Int,
    var balance: Double,
    val customer: Customer
) {


}




