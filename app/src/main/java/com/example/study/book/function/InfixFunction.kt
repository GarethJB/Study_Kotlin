package com.example.study.book.function


// ▶ 중위 함수 ◀

// 중위 표현법 (Infix Notion)이란 클래스의 멤버를 호출할 때 사용하는 점(.) 을 생략하고
// 함수 이름 뒤에 소괄호를 붙이지 않아 직관적인 이름을 사용할 수 있는 표현법
// 즉, 중위 함수란 일종의 연산자를 구현할 수 있는 함수를 말한다
// # 중위 함수의 조건
// 1. 멤버 메소드 또는 확장 함수여야 한다
// 2. 하나의 파라미터를 가져야 한다
// 3. infix 키워드를 사용하여 정의한다

fun main() {

    // 일반 표현법
    // val multi = 3.multiply(10)

    // 중위 표현법
    val multi = 3 multiply 10
    println("multi : $multi")
}


// Int 를 확장해서 multiply() 함수를 하나 더 추가함
infix fun Int.multiply(x: Int): Int {   // infix 로 선언되므로 중위 함수
    return this * x
}