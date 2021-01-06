package com.example

data class Human(
    val name: String = "Vasily",
    val age: Int = 18,
    val weight: Int = 80,
    val height: Int = 180,
    val isMale:Boolean = true
) {
    fun isEmpty() = this === EMPTY

    companion object {
        val EMPTY = Human()
    }
}
