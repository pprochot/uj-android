package com.github.pprochot.uj.android.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var mathExpressionBuilder: MathExpressionBuilder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.result)
        mathExpressionBuilder = MathExpressionBuilder()
        setUpButtons()
    }

    private fun setUpButtons() {
        findViewById<Button>(R.id.button_0).setOnClickListener { addNumberAndPrint(0) }
        findViewById<Button>(R.id.button_1).setOnClickListener { addNumberAndPrint(1) }
        findViewById<Button>(R.id.button_2).setOnClickListener { addNumberAndPrint(2) }
        findViewById<Button>(R.id.button_3).setOnClickListener { addNumberAndPrint(3) }
        findViewById<Button>(R.id.button_4).setOnClickListener { addNumberAndPrint(4) }
        findViewById<Button>(R.id.button_5).setOnClickListener { addNumberAndPrint(5) }
        findViewById<Button>(R.id.button_6).setOnClickListener { addNumberAndPrint(6) }
        findViewById<Button>(R.id.button_7).setOnClickListener { addNumberAndPrint(7) }
        findViewById<Button>(R.id.button_8).setOnClickListener { addNumberAndPrint(8) }
        findViewById<Button>(R.id.button_9).setOnClickListener { addNumberAndPrint(9) }

        findViewById<Button>(R.id.button_plus)
            .setOnClickListener { addOperatorAndPrint(MathOperator.PLUS) }
        findViewById<Button>(R.id.button_minus)
            .setOnClickListener { addOperatorAndPrint(MathOperator.MINUS) }
        findViewById<Button>(R.id.button_multiply)
            .setOnClickListener { addOperatorAndPrint(MathOperator.MUL) }
        findViewById<Button>(R.id.button_divide)
            .setOnClickListener { addOperatorAndPrint(MathOperator.DIV) }

        findViewById<Button>(R.id.button_clear).setOnClickListener { removeSymbolAndPrint() }
        //TODO liczby po przecinku
        findViewById<Button>(R.id.button_equals).setOnClickListener {
            val result = mathExpressionBuilder.build().evaluate()
            textView.text = result.toPlainString()
            mathExpressionBuilder = MathExpressionBuilder(result)
        }
    }

    private fun addNumberAndPrint(number: Int) {
        mathExpressionBuilder.addNumber(number)
        textView.text = mathExpressionBuilder.toStringForm()
    }

    private fun addOperatorAndPrint(operator: MathOperator) {
        mathExpressionBuilder.addOperator(operator)
        textView.text = mathExpressionBuilder.toStringForm()
    }

    private fun removeSymbolAndPrint() {
        mathExpressionBuilder.removeSymbol()
        textView.text = mathExpressionBuilder.toStringForm()
    }
}