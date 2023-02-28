package com.example.study.book.lambda


// ◆ 고차 함수의 형태 ◆


// ▶ 일반 함수를 인자나 반환값으로 사용하는 고차함수 ◀

fun main() {

    // 인자에 일반함수 사용
    val res1 = sum(3, 2)    // 일반 인자
    val res2 = mul(sum(3, 3), 3)    // 인자에 함수를 사용

    println("res1 : $res1")
    println("res2 : $res2")

    println("funcFunc : ${funcFunc()}")
}

fun sum(a: Int, b: Int) = a + b
fun mul(a: Int, b: Int) = a * b

// 반환값에 일반함수 사용
fun funcFunc(): Int {
    return sum(2, 2)
}

