package com.manu.mvvmsumapp.viewmodel

import androidx.lifecycle.ViewModel
import com.manu.mvvmsumapp.model.CalculatorModel

class CalculatorViewModel: ViewModel() {

    fun calculate(num1: Int, num2: Int): CalculatorModel {
        val sum = num1 + num2
        return CalculatorModel(num1, num2, sum)
    }
}