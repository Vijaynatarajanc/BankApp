package com.vijaynatarajan.bankappcore

class Bank(
    val name: String, var accountBalance: Double = 0.0

) {
    var nextAccountId: Int = 1
    private var accounts = mutableListOf<BankAccount>()

    fun createAccount(accountBalance: Double, customer: Customer): BankAccount {
        this.accountBalance = accountBalance
        val account = BankAccount(nextAccountId++, accountBalance, customer)
        accounts.add(account)
        return account

    }

    fun deposit(amount: Double, bankAccount: BankAccount): Double {
        bankAccount.balance += amount

        return bankAccount.balance
    }

    fun withdrawn(amount: Double, bankAccount: BankAccount): Double {
        if (bankAccount.balance < amount) throw InsufficientBalance("Insufficient balance, Please check account balance!!")

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

    val vijay = Customer(1234, "vijay", "12v,veeraganur", 1234, "savings account")
    val jack = Customer(5678, "jack", "24g", 123456789, "salary Account")

//    val vijayAccount = bank.createAccount(5000.0, vijay)
    val jackAccount = bank.createAccount(10000.0, jack)
//    val saravanan = bank.createAccount(120000.0,customer)
//    val anbu = bank.createAccount(500000.0,customer)

    println("Created account with id ${jackAccount.accountId} and balance ${jackAccount.balance}")
    bank.getAccountList().forEach {
        println("Name :${it.customer.name}")
        println("Account number:${it.customer.accountNumber}")
        println("password :${it.customer.password}")
        println("Address:${it.customer.address}")
        println("Account type:${it.customer.accountType}")
        println("Balance:${it.balance}")
        println("AccountId:${it.accountId}")

    }
    println(bank.getAccountSize())
    bank.deleteAllAccount()
    println(bank.getAccountSize())

    bank.getAccountList().forEach {
        println(it)
    }

    println(bank.deposit(500.0, jackAccount))
    try {
        println(bank.withdrawn(500.0, jackAccount))
    } catch (e: InsufficientBalance) {
        println(e)
    }

    println(bank.getBalance(jackAccount))
}




