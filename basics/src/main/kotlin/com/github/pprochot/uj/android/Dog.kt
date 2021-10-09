package com.github.pprochot.uj.android

data class Dog(val name: String) : Animal() {

    override fun toString(): String {
        return "dog's name: ${name}"
    }
}