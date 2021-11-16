package com.github.pprochot.uj.android.calculator

import java.math.BigDecimal

interface MathExpression {

    fun evaluate(): BigDecimal
}