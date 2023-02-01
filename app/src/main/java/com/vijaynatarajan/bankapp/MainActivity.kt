package com.vijaynatarajan.bankapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vijaynatarajan.bankappcore.Bank

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bank = Bank("Bank Of Saravanan")

        bank.name
    }
}