package com.vijaynatarajan.bankappcore

class Bank(
    val name: String,
    var accountBalance: Double = 500.0
) {


    fun deposit(amount: Double): Double {
        accountBalance += amount
        return accountBalance
    }

    fun withdrawn(amount: Double): Double {
        if (accountBalance < amount)
            throw InsufficientBalance("Insufficient balance, Please check account balance!!")

        accountBalance -= amount
        return amount
    }

    fun getBalance() = accountBalance


}

class InsufficientBalance(message: String) : Exception(message)


fun main(args: Array<String>) {
    var bank = Bank("SBI")
    println(bank.deposit(500.0))
    try {
        println(bank.withdrawn(500.0))
    } catch (e: InsufficientBalance) {
        println(e)
    }

    println(bank.getBalance())

    
}


