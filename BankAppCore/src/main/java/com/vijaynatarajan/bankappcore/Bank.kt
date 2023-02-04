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
        if (accountBalance >= amount) {

            accountBalance -= amount
        } else {
            throw CustomException("In Sufficient Fund")
        }
        return amount
    }

    fun getBalance() = accountBalance


}

class CustomException(message: String) : Exception(message)


fun main(args: Array<String>) {
    var bank = Bank("SBI")
    println(bank.deposit(1000.0))
    try {
        println(bank.withdrawn(3000.0))
    } catch (e: CustomException) {
        println(e)
    }

    println(bank.getBalance())
}


