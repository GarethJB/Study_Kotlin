package com.example.study.book.conditionalstatement



// ◆ when ◆

// 자바의 switch 문과 비슷하지만 각 수행 문장을 멈추는 break 와 같은 문장이 필요하지 않음

fun main() {

    //
    print("Enter the score: ")
    val score = readLine()!!.toDouble()
    var grade: Char = 'F'

    // 인자가 있는 when 조건문
    when(score) {
        in 90.0 .. 100.0 -> grade = 'A'
        in 80.0 .. 89.9 -> grade = 'B'
        in 70.0 .. 79.9 -> grade = 'C'
        in 60.0 .. 69.9 -> grade = 'D'
        !in 60.0 .. 100.0 -> grade = 'F'
    }

    when {
        score <= 10.0 -> grade = 'Z'    // 인자가 없는 when 조건문은 조건식을 구성할 수 있음
    }

    println("Score: $score, Grade: $grade")

    println()

    cases("Hello")
    cases(1)
    cases(System.currentTimeMillis())
}

// 다양한 자료형의 인자 받기
fun cases(obj: Any) {
    when (obj) {
        1 -> println("Int: $obj")
        "Hello" -> println("String: $obj")
        is Long -> println("Long: $obj")
        !is String -> println("Not a String")
        else -> println("Unknown")
    }
}