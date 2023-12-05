package com.manu.mvvmsumapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.manu.mvvmsumapp.R
import com.manu.mvvmsumapp.databinding.ActivitySumBinding
import com.manu.mvvmsumapp.viewmodel.CalculatorViewModel

class SumActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySumBinding.inflate(layoutInflater) }
    private lateinit var calculatorViewModel: CalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        calculatorViewModel = ViewModelProvider(this) [CalculatorViewModel::class.java]

        binding.buttonCalculate.setOnClickListener {
            if(binding.etNum1.text.toString().isEmpty()) {
                binding.etNum1.error = "Empty"
            } else if(binding.etNum2.text.toString().isEmpty()) {
                binding.etNum2.error = "Empty"
            } else {
                calculate()
            }
        }
    }

    private fun calculate() {
        val num1 = binding.etNum1.text.toString().toIntOrNull() ?: 0
        val num2 = binding.etNum2.text.toString().toIntOrNull() ?: 0

        val result = calculatorViewModel.calculate(num1, num2)

        binding.tvResult.text = "${result.sum}"

    }
}