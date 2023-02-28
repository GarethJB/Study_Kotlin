package com.example.study.book.function


// ◆ 함수 ◆

// 함수는 여러 값(인자)를 입력받아 기능을 수행하고 결과값을 반환하는 코드의 모음이다


// ▶ 함수의 구조 ◀
fun sum(a: Int, b: Int): Int {
    var sum = a + b
    return sum
}

// 1. fun 키워드로 함수 선언 시작하기
// 2. 함수 이름 짓기 → sum
// 3. 매개변수 정의하기 → 반드시 : 과 함께 자료형을 명시
// 4. 반환값의 자료형 명시하기 → Int
// 5. 함수의 본문 완성하기 → 중괄호 { } 안에 수행할 기능을 코드로 작성
// 6. 값 반환하기 → 본문에서 기능을 수행하여 값을 반환할 때 return 키워드와 함께 반환할 값 명시


// ▶ 함수 호출과 프로그램의 실행 순서 ◀



fun main() {
    val result1 = sum(3, 2)
    val result2 = sum(6, 7)

    println("result1 : $result1")
    println("result2 : $result2")




}