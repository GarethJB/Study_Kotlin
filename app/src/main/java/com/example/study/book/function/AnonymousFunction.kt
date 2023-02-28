package com.example.study.book.function


// ▶ 익명 함수 ◀
//  익명 함수 (Anonymous Function)란 일반 함수지만 이름이 없는 것
//fun (x: Int, y: Int): Int = x + y // 함수 이름이 생략된 익명 함수

// 함수의 본문 조건식에 따라 함수를 중단하고 반환해야 하는 경우에 익명 함수를 사용

fun main() {

    val add: (Int, Int) -> Int = fun(x, y) = x + y  // 익명 함수를 사용한 add 선언
    val result = add(10, 2) // add 사용

    val add2 = fun(x: Int, y: Int) = x + y
    val add3 = { x: Int, y: Int -> x + y}
}

