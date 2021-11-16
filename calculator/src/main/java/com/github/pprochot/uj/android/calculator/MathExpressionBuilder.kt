package com.github.pprochot.uj.android.calculator

import java.math.BigDecimal

class MathExpressionBuilder {

    private val stringBuilder = StringBuilder()
    private var operator: MathOperator? = null

    constructor()

    constructor(number: BigDecimal) {
        stringBuilder.append(number)
    }

    fun addNumber(number: Int) {
        if (operator == MathOperator.DIV && number == 0)
            return
        stringBuilder.append(number)
    }

    fun addOperator(mathOperator: MathOperator) {
        if (canAddMinusToNumber()) {
            stringBuilder.append("-")
        } else if (stringBuilder.isNotEmpty() && !hasOperator()) {
            operator = mathOperator
            stringBuilder.append(mathOperator.symbol)
        }
    }

    fun removeSymbol() {
        if (isLastSymbolOperator())
            operator = null
        stringBuilder.removeLast()
    }

    fun toStringForm(): String {
        return stringBuilder.toString()
    }

    fun build(): MathExpression {
        if (stringBuilder.isEmpty())
            return SingleMathExpression(BigDecimal.ZERO)
        if (hasOperator()) {
            if (isLastSymbolOperator()) {
                return singleMathExpressionWithoutOperator()
            }
            return doubleMathExpression()
        }
        return singleMathExpression()
    }

    private fun hasOperator(): Boolean {
        return operator != null
    }

    private fun isLastSymbolOperator(): Boolean {
        return stringBuilder.isNotEmpty() && operator?.symbol == stringBuilder.last().toString()
    }

    private fun canAddMinusToNumber(): Boolean {
        return stringBuilder.isEmpty()
                || operator == MathOperator.MUL
                || operator == MathOperator.DIV
    }

    private fun doubleMathExpression(): MathExpression {
        val indexOfOperator = stringBuilder.indexOf(operator!!.symbol)
        val firstNumber = stringBuilder.substring(0, indexOfOperator).toBigDecimal()
        val secondNumber = stringBuilder.substring(indexOfOperator + 1).toBigDecimal()

        return DoubleMathExpression(firstNumber, secondNumber, operator!!)
    }

    private fun singleMathExpressionWithoutOperator(): SingleMathExpression {
        val number = stringBuilder.substring(0, stringBuilder.lastIndex)
        return SingleMathExpression(number.toBigDecimal())
    }

    private fun singleMathExpression(): MathExpression {
        return SingleMathExpression(stringBuilder.toString().toBigDecimal())
    }

    private fun StringBuilder.removeLast() {
        if (this.isNotEmpty())
            this.deleteCharAt(this.lastIndex)
    }
}