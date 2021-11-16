package com.github.pprochot.uj.android.calculator

import java.math.BigDecimal
import java.math.RoundingMode

enum class MathOperator(
    val calculate: (BigDecimal, BigDecimal) -> BigDecimal,
    val symbol: String
) {

    PLUS({ a, b -> a.plus(b) }, "+"),
    MINUS({ a, b -> a.minus(b) }, "-"),
    MUL({ a, b -> a.times(b) }, "*"),
    DIV({ a, b ->
        val roundedResult = a.divide(b, 5, RoundingMode.HALF_UP)
        val formatter = java.text.DecimalFormat("0.##")
        BigDecimal(formatter.format(roundedResult))
    }, "/"); //TODO div 0
}
