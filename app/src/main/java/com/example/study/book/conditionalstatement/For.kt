package com.example.study.book.conditionalstatement



// ◆ for ◆

// 코틀린에서는 for 문에 in 연산자를 사용

// for ([요소 변수] in [컬렉션 또는 범위]) {[반복할 본문]}

// for 문은 내부적으로 반복을 처리하는 인터페이스인 이터레이터에 의해
// 배열이나 특정 값의 범위, 컬렉션으로 불리는 요소 등에서 사용할 수 있다

fun main() {

    // 1부터 10까지 더하기
    var sum = 0

    for (x in 1..10) sum += x
    println("sum: $sum")

    println()

    // 하행 반복 방법
    for (i in 5 downTo 1) print(i)

    println("\n")

    // 숫자를 2단계씩 증가
    for (i in 1..5 step 2) print(i)

    println("\n")

    // downTo 와 step 혼합 사용
    for (i in 5 downTo 1 step 2) print(i)

    println("\n")

    // 삼각형 출력하기
    val n: Int = 5

    for (line in 1..n) {
        for (space in 1..(n - line)) print(" ") // 공백 출력
        for (star in 1..(2 * line - 1)) print("★")  // 별 출력
        println()   // 개행
    }
}
