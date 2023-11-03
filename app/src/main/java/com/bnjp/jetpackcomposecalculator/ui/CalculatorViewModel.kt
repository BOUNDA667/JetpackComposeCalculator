package com.bnjp.jetpackcomposecalculator.ui

import androidx.lifecycle.ViewModel
import com.notkamui.keval.Keval
import com.notkamui.keval.KevalException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CalculatorViewModel: ViewModel() {
    private  val _uiState = MutableStateFlow(CalculatorUiState())
    val uiState: StateFlow<CalculatorUiState> = _uiState.asStateFlow()
    private lateinit var answer: String

    init {
        clearAll()
    }
    private fun clearAll() {
        _uiState.value = CalculatorUiState()
    }

    fun getCliquedButtonChar(cliquedButtonChar: Char) {
        _uiState.value.cliquedButton = cliquedButtonChar
        when(cliquedButtonChar) {
            'C' -> clearAll()
            '=' -> setAnswerView()
            else -> {
                setOperationView(char = cliquedButtonChar)
            }
        }
    }

    private fun changeOperator(expressionCharArray: CharArray): String {
        for (i in expressionCharArray.indices) {
            if (expressionCharArray[i] == 'x') {
                expressionCharArray[i] = '*'
            }
            else if (expressionCharArray[i] == '÷') {
                expressionCharArray[i] = '/'
            }
        }
        return String(expressionCharArray)
    }

    private fun evalExpression(expression: String): String {
      //  val expressionCharArray = expression.toCharArray()
        val newExpression = changeOperator(expression.toCharArray())
         try {
             answer = Keval.eval(newExpression).toString()
        } catch (error: KevalException) {
             _uiState.value.isError = true
        }
        return answer
    }

    private fun setAnswerView() {
        answer = evalExpression(_uiState.value.operationView)
        _uiState.update { currentState ->
            currentState.copy(answerView = answer)
        }
    }

    private fun setOperationView(char: Char) {
        val value = if(_uiState.value.operationView == "0") {
            char.toString()
        }
        else { "${_uiState.value.operationView}$char" }
        _uiState.update { currentState ->
            currentState.copy(
                operationView = value
            )
        }
    }
}