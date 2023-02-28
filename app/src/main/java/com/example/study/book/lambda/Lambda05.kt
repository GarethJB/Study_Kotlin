package com.example.study.book.lambda

// ◆ 다른 함수의 참조에 의한 일반 함수 호출 ◆

// 참조에 의한 호출 방식으로 일반 함수 호출하기
fun main() {

    // 인자와 반환값이 있는 함수
    val res1 = funcParam(3, 2, ::sum2)
    println("res1 : $res1")

    // 인자가 없는 함수
    hello(::text)   // 반환값이 없음
    // body: (String, String) -> String
    // body → String 두 개를 매개변수로 받아 String 으로 반환
    // 매개변수 body 에 text 가 대응됨

    hello(::text2)


    // 일반 변수에 값처럼 할당
    val likeLambda = ::sum2
    println(likeLambda(6, 6))
}

fun sum2(a: Int, b: Int) = a + b

fun text(a: String, b: String): String {
    println("a: $a")
    println("b: $b")
    var qq = "Hi! $a $b"
    println("text $qq")
    return qq
}

// text() 가 먼저 실행

fun text2(a: String, b: String) = "bye"

fun funcParam(a: Int, b: Int, c: (Int, Int) -> Int): Int {
    return c(a, b)
}

fun hello(body: (String, String) -> String): Unit {
    println("c")
    println(body("Hello", "World"))
}