package com.example.study.book.lambda

// ◆ 람다식과 고차함수 호출 ◆

// ▶ 값에 의한 호출 (Call by Value) ◀
// 코틀린에서 값에 의한 호출은
// 함수가 또 다른 함수의 인자로 전달될 경우 람다식 함수는 값으로 처리되어 즉시 함수가 수행된 후 값 전달

fun callByValue(b: Boolean): Boolean {  // 일반 변수 자료형으로 선언된 매개변수
    println("callByValue function")
    return b
}

val lambda: () -> Boolean = {   // 람다 표현식이 2줄
    println("lambda function")
    true
    // 마지막 표현식 문장의 결과가 반환
}

fun main() {
    val result = callByValue(lambda())  // 람다식 함수를 호출
    println(result)
}

/*
    1. callByValue(lambda())에서 인자로 전달된 lambda()가 먼저 수행
    2. lambda() 의 람다식에 의해 "lambda function" 을 화면에 출력하고 true 를 반환
    3. callByValue() 함수의 b에 값(true)을 복사
    4. callByValue() 함수의 본문인 println() 이 수행되어 "callByValue function" 출력
    5. b를 최종적으로 반환
    6. 반환된 값은 다시한면 result 변수에 할당되어 true 를 출력

*/




