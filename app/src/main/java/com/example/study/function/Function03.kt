package com.example.study.function

// ◆ 반환값이 없는 함수 ◆

    // 두 인자를 그대로 출력하는 함수는 값을 반환하지 않아도 된다
    // 반환값의 자료형을 Unit 으로 지정하거나 생략할 수 있다
    // Unit 은 코틀린에서 다루는 특수한 자료형 중 하나로 반환값이 없을 때 사용

// ▶ Unit 을 리턴값의 자료형으로 지정한 함수 ◀
fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}


// ▶ Unit 을 생략하여 작성 ◀
// 함수에서 반환값과 반환값의 자료형이 없으면 반환값의 자료형을 Unit 으로 추론
fun printSum2(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}