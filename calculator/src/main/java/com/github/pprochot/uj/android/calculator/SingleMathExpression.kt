package com.github.pprochot.uj.android.calculator

import java.math.BigDecimal

class SingleMathExpression(private val number: BigDecimal) : MathExpression {

    override fun evaluate(): BigDecimal {
        return number
    }
}