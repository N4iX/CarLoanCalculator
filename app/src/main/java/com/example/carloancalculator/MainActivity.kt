package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            calculateLoan()
        }
    }

    private fun calculateLoan(){

        if(editTextCarPrice.text.isEmpty()){
            editTextCarPrice.setError(getString(R.string.error))
            return
        }

        if(editTextDownPayment.text.isEmpty()){
            editTextDownPayment.setError(getString(R.string.error))
            return
        }

        if(editTextLoanPeriod.text.isEmpty()){
            editTextLoanPeriod.setError(getString(R.string.error))
            return
        }

        if(editTextInterestRate.text.isEmpty()){
            editTextInterestRate.setError(getString(R.string.error))
            return
        }

        //TODO: Get all inputs from user and perform calculation
        val carPrice = editTextCarPrice.text.toString().toFloat()
        val downPayment = editTextDownPayment.text.toString().toInt()
        val loanPeriod = editTextLoanPeriod.text.toString().toInt()
        val interestRate = editTextInterestRate.text.toString().toFloat()

        val loan = carPrice - downPayment
        val interest = loan * interestRate * loanPeriod
        val monthlyRepayment = (loan + interest) / loanPeriod / 12

        val currency = Currency.getInstance(Locale.getDefault())

        //TODO: Display the outputs
        textViewLoan.setText(getString(R.string.loan) + " " + currency.getCurrencyCode() + " ${loan}") //dollar sign to convert to string
        textViewInterest.setText(getString(R.string.interest) + " " + currency.getCurrencyCode() + " ${interest}")
        textViewMonthlyRepayment.setText(getString(R.string.monthly_repayment) + " " + currency.getCurrencyCode() + " ${monthlyRepayment}")
    }

    fun resetInput(view: View) {
        //TODO: Clear all inputs and outputs
        editTextCarPrice.setText("")
        editTextDownPayment.setText("")
        editTextLoanPeriod.setText("")
        editTextInterestRate.setText("")

        textViewLoan.setText("")
        textViewInterest.setText("")
        textViewMonthlyRepayment.setText("")
    }
}
