package com.vijaynatarajan.bankappcore

class Bank(
    val name: String,
    val branchName: String,
    val address: String,
    val ifscCode: String,
    val micrCode: String,
    val phoneNo: Int,

    ) {

    var customerId: Int = 1
    private var accounts = mutableListOf<BankAccount>()

    fun createAccount(accountBalance: Double, customer: Customer): BankAccount {
        val account = BankAccount(customerId++, accountBalance, customer)
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
    val bank =
        Bank(
            "SBI",
            "Madurai",
            "12v, Rajalaxmi layout,Madurai",
            "SDBI000I008",
            "1234567",
            45678
        )

    val vijay = Customer(
        1234,
        "vijay",
        "12v,veeraganur",
        1234,
        "savings account",
        123456789101,
        "xyz00asf"
    )
    val jack = Customer(
        5678,
        "jack",
        "24g",
        123456789,
        "salary Account",
        123456782345,
        "bgh005xvm"

    )

//    val vijayAccount = bank.createAccount(5000.0, vijay)
    val jackAccount = bank.createAccount(10000.0, jack)
//    val saravanan = bank.createAccount(120000.0,customer)
//    val anbu = bank.createAccount(500000.0,customer)

    println("Created account with id ${jackAccount.customerId} and balance ${jackAccount.balance}")
    bank.getAccountList().forEach {
        println("Name :${it.customer.name}")
        println("Account number:${it.customer.accountNumber}")
        println("password :${it.customer.password}")
        println("Address:${it.customer.address}")
        println("Account type:${it.customer.accountType}")
        println("Balance:${it.balance}")
        println("customerId:${it.customerId}")
        println("AadhaarNo:${it.customer.aadhaarNo}")
        println("panNo:${it.customer.panCardNo}")

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




