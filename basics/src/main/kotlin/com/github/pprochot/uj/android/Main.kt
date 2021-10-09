package com.github.pprochot.uj.android

fun main() {
    val dogs = listOf<Dog>(Dog("Hauf"), Dog("Buli"), Dog("Dingo"))
    for (dog in dogs) {
        println(dog)
    }

    for (index in dogs.indices) {
        println("Index: {$index}")
    }

    Functions().whenFunc(1)

    if (-1 !in dogs.indices) {
        println("Incorrect index!")
    }

    if (dogs.size in dogs.indices) {
        println("Size of list fits range")
    }

    for (x in 1..10 step 2) {
        println("X: {$x}")
    }

    for (x in 9 downTo 1 step 3) {
        println("X: {$x}")
    }

    when {
        Dog("Buli") in dogs -> println("Buli is in dogs list!")
    }

    dogs.filter { it.name.startsWith("Ha") }
        .map { it.name.uppercase() }
        .forEach { println(it) }


    val dogs2: Any = dogs

    if (dogs2 is Collection<*>) {
        println(dogs.size)
    }

    val map = mapOf("1" to 1, "2" to 2, "3" to 3)
    for ((k, v) in map) {
        println("{$k}, {$v}")
    }

    val values = mapOf("key" to null)
    values["key"] ?: println("Incorrect index")
}