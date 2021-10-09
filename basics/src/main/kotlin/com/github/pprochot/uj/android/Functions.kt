package com.github.pprochot.uj.android

import java.math.BigDecimal

class Functions {

    fun sumClassic(a: Int, b: Int): Int {
        return a + b;
    }

    fun sumPretty(a: Int, b: Int) = a + b;

    fun maxOf(a: Int, b: Int) = if (a > b) a else b

    fun whenFunc(obj: Any) {
        when (obj) {
            1 -> println("Int")
            "G" -> println("String")
            is Long -> println("Long")
            !is BigDecimal -> println("Good old java BigDecimal")
            else -> println("Some other type")
        }
    }

    fun isNull(a: Int?) = if (a == null) true else false
}