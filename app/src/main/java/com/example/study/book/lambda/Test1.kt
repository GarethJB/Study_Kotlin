package com.example.study.book.lambda

/*
    ▶ 고차함수란?

    함수를 마치 클래스에서 만들어낸 '인스턴스' 처럼 취급하는 방법
    함수를 파라미터로 넘겨줄 수도 있고
    결과값으로 반환 받을 수도 있음
*/

fun main() {

    b(::a)  // 일반 함수를 고차 함수로 변경해 주는 연산자

    val c: (String) -> Unit = {str -> println("$str 람다함수") }
    b(c)
}

fun a (str: String) {
    println("$str 함수 a")
}

fun b (function: (String) -> Unit) {
    function("b가 호출한")
}