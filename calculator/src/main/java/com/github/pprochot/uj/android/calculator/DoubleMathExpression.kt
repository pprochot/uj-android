package com.github.pprochot.uj.android.calculator

import java.lang.StringBuilder
import java.math.BigDecimal
import java.util.*

class DoubleMathExpression(
    private val firstNumber: BigDecimal,
    private val secondNumber: BigDecimal,
    private val operator: MathOperator
) : MathExpression {

    override fun evaluate(): BigDecimal {
        return operator.calculate(firstNumber, secondNumber)
    }
}
