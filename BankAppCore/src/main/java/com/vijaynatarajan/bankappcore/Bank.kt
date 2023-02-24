package com.vijaynatarajan.bankappcore

class Bank(
    val name: String,
    var accountBalance: Double = 0.0

) {
    var nextAccountId: Int = 1
    private var accounts = mutableListOf<BankAccount>()

    fun createAccount(accountBalance: Double): BankAccount {
        this.accountBalance = accountBalance
        val account = BankAccount(nextAccountId++, accountBalance)
        accounts.add(account)
        return account

    }

    fun deposit(amount: Double, bankAccount: BankAccount): Double {
        bankAccount.balance += amount

        return bankAccount.balance
    }

    fun withdrawn(amount: Double, bankAccount: BankAccount): Double {
        if (bankAccount.balance < amount)
            throw InsufficientBalance("Insufficient balance, Please check account balance!!")

        bankAccount.balance -= amount
        return amount
    }

    fun getBalance(bankAccount: BankAccount): Double {

        return bankAccount.balance

    }


    fun getAccountList(): List<BankAccount> {

        return accounts
    }

    fun getAccountSize() = accounts.size


    fun deleteAllAccount() {

        accounts.clear()
    }


}

class InsufficientBalance(message: String) : Exception(message)


fun main(args: Array<String>) {
    val bank = Bank("SBI")

    val vijay = bank.createAccount(5000.0)
    val jack = bank.createAccount(10000.0)
    val saravanan = bank.createAccount(120000.0)
    val anbu = bank.createAccount(500000.0)

    println("Created account with id ${vijay.accountId} and balance ${vijay.balance}")
    bank.getAccountList().forEach {
        println(it)
    }
    println(bank.getAccountSize())
    bank.deleteAllAccount()
    println(bank.getAccountSize())

    bank.getAccountList().forEach {
        println(it)
    }

    println(bank.deposit(500.0, vijay))
    try {
        println(bank.withdrawn(500.0, vijay))
    } catch (e: InsufficientBalance) {
        println(e)
    }

    println(bank.getBalance(vijay))
}




