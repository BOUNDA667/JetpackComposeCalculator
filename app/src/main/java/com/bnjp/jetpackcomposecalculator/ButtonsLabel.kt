package com.bnjp.jetpackcomposecalculator

val buttonsLabel: Map<String, Set<Int>> = mapOf(
    "column1" to setOf(
        R.string.clear,
        R.string.seven,
        R.string.four,
        R.string.one,
        R.string.point
        ),
    "column2" to setOf(
        R.string.toggleSigne,
        R.string.openParenthesis,
        R.string.eight,
        R.string.five,
        R.string.two,
        R.string.zero
    ),
    "column3" to setOf(
        R.string.modulo,
        R.string.closeParenthesis,
        R.string.nine,
        R.string.six,
        R.string.three,
        R.string.backspace
    ),
    "column4" to setOf(
        R.string.multiply,
        R.string.divide,
        R.string.substract,
        R.string.sum,
        R.string.equal
    )
)