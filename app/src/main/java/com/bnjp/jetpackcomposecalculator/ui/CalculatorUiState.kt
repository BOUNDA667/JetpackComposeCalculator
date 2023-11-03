package com.bnjp.jetpackcomposecalculator.ui

data class CalculatorUiState(
    var cliquedButton: Char? = null,
    var answerView: String = "0",
    var operationView: String = "0",
    var beforValue: Double? = null,
    var afterValue: Double? = null,
    var currentOperator: Char? = null,
    var isError: Boolean = false
)
