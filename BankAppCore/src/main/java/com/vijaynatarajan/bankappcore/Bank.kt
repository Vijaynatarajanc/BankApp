package com.vijaynatarajan.bankappcore

class Bank(
    val name: String,
    val branch_Name: String,
    val address: String,
    val IFSC_Code: String,
    val MICR_Code: String,
    val phone_No: Int,

    ) {

    var customerId: Int = 1
    private var accounts = mutableListOf<BankAccount>()

    fun createAccount(
        accountBalance: Double,
        customer: Customer,
        accountNumber: Int,
        accountType: String,
    ): BankAccount {

        val account = BankAccount(
            account_customer_id = customerId++,
            account_number = accountNumber,
            account_type = accountType,
            customer = customer,
            account_balance = accountBalance
        )
        accounts.add(account)
        return account

    }

    fun deposit(amount: Double, bankAccount: BankAccount): Double {
        bankAccount.account_balance += amount

        return bankAccount.account_balance
    }

    fun withdrawn(amount: Double, bankAccount: BankAccount): Double {
        if (bankAccount.account_balance < amount) throw InsufficientBalance("Insufficient balance, Please check account balance!!")

        bankAccount.account_balance -= amount
        return amount
    }

    fun getBalance(bankAccount: BankAccount): Double {

        return bankAccount.account_balance

    }


    fun getAccountList(): List<BankAccount> {

        return accounts
    }

    fun getAccountSize() = accounts.size


    fun deleteAllAccount() {

        accounts.clear()
    }

    fun deleteAccount(accountNumber: Int) {
        val delete = accounts.find {
            it.account_number == accountNumber
        }
        accounts.remove(delete)
    }

    fun editAccount(accountNumber: Int): BankAccount? {
        val edit = accounts.find {
            it.account_number == accountNumber
        }
        return edit
    }

    fun searchAccount(accountNumber: Int): BankAccount? {
        val search = accounts.find {
            it.account_number == accountNumber
        }
        return search
    }


    var employeeId: Int = 1
    var employeeDetails = mutableListOf<Employees>()

    fun addEmployees(
        employeeId: Int,
        employeeName: String,
        employeeMobileNo: Long,
        employeeEmailId: String,
        userName: String,
        password: String,
        address: String
    ): Employees {

        val employDetail = Employees(
            employee_name = employeeName,
            employee_mobileNo = employeeMobileNo,
            employee_email = employeeEmailId,
            employee_userName = userName,
            employee_password = password,
            employee_address = address
        )
        employeeDetails.add(employDetail)
        return employDetail
    }

    fun getEmployList(): List<Employees> {

        return employeeDetails
    }

    fun getAccountSiz() = employeeDetails.size

    fun deleteAllEmployee() {

        employeeDetails.clear()
    }



}

class InsufficientBalance(message: String) : Exception(message)


fun main(args: Array<String>) {
    val bank = Bank(
        "SBI",
        "Madurai",
        "12v, Rajalaxmi layout,Madurai",
        "SDBI000I008",
        "1234567",
        45678
    )

    val john = Customer(
        "John", 12345,
        "Saving",
        4321,
        "12v,welington",
        123456789102,
        "xt243ft",
        123456789
    )

    val jack = Customer(
        "Jack", 6789,
        "Current",
        8765,
        "13g,Northompton",
        456756789102,
        "dc342hg",
        9845674980
    )

    val vijayAccount = bank.createAccount(5000.0, john, 12345, "Savings")
    val jackAccount = bank.createAccount(10000.0, jack, 678910, "Current")

//    bank.getAccountList().forEach {
//        println("Name :${it.customer.name}")
//        println("Account number:${it.customer.account_Number}")
//        println("password :${it.customer.password}")
//        println("Address:${it.customer.address}")
//        println("Account type:${it.customer.accountType}")
//        println("Balance:${it.account_balance}")
//        println("customerId:${it.account_customer_id}")
//        println("AadhaarNo:${it.customer.aadhaarNo}")
//        println("panNo:${it.customer.panCardNo}")

//    }
//    println(bank.getAccountSize())
//    bank.deleteAllAccount()
//    println(bank.getAccountSize())

//    bank.getAccountList().forEach {
//        println(it)
//    }
//
//    println(bank.deposit(500.0, jackAccount))
//    try {
//        println(bank.withdrawn(500.0, jackAccount))
//    } catch (e: InsufficientBalance) {
//        println(e)
//    }
//
//    println(bank.getBalance(jackAccount))

//    bank.deleteAccount(12345)
//    bank.editAccount(12345)?.apply {
//
//        this.customer.phone_No = 12345678
//    }
//    bank.searchAccount(12345).let { it ->
//        if (it != null) {
//            println(it.account_number)
//            println(it.account_balance)
//            println(it.account_type)
//            println(it.account_customer_id)
//            println(it.customer.name)
//            println(it.customer.phone_No)
//        }


//    println("\n\n##########\n\n")
//    bank.getAccountList().forEach {
//        println("Name :${it.customer.name}")
//        println("Account number:${it.customer.account_Number}")
//        println("password :${it.customer.password}")
//        println("Address:${it.customer.address}")
//        println("Account type:${it.customer.accountType}")
//        println("Balance:${it.account_balance}")
//        println("customerId:${it.account_customer_id}")
//        println("AadhaarNo:${it.customer.aadhaarNo}")
//        println("panNo:${it.customer.panCardNo}")

    val jamsAnderson = Employees(
        "JamsAnderson",
        1234567891,
        "jams1232@gmail.com",
        "Anderson",
        "jams@123",
        "18j,Moscow"
    )
    val stuartBroad = Employees(
        " stuartBroad",
        6789123450,
        "broad1232@gmail.com",
        "Broad",
        "Broad@123",
        "15l,London"
    )


}







