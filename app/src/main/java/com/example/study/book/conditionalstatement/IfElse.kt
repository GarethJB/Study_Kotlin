package com.example.study.book.conditionalstatement



// ◆ if - else ◆

// ▶ in 연산자와 범위 연산자로 조건식 간략화
// [변수] in [시작값] .. [마지막값]

fun main() {
    print("Enter the score: ")
    val score = readLine()!!.toDouble() // readLine() 함수로 콘솔로부터 문자열을 입력받음
    var grade: Char = 'F'

    if (score >= 90.0) {
        grade = 'A'
    }else if (score in 80.0 .. 89.9) {
        grade = 'B'
    }else if (score in 70.0 .. 79.9) {
        grade = 'C'
    }else if (score in 60.0 .. 69.9) {
        grade = 'D'
    }

    println("Score: $score, Grade: $grade")
}