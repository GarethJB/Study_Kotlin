package com.example.study.note



// ▶ Call by Value
/*  스택영역에 저장된 값을 호출하는 것
    즉, 함수가 인자로 전달되었을 경우에 전달된 함수를 즉시 평가(함수의 수행) 하는 것을 말한다    */

fun main() {
    callByValue(funA())
    // funA() 함수를 파라미터로 전달
}

fun callByValue(b: Boolean): Boolean {
    // 함수가 아닌 값을 인자로 전달받았다
    println("CallByValue")
    return b
}

val funA: () -> Boolean = {
    println("funA")
    true
}

/*
    funA() 는 callByValue() 함수의 파라미터로 전달된다
    전달 된 값을 사용하는 시점은 callByValue() 함수 내부에서
    println("callByValue") 가 호출된 이후이다
    즉, 전달받은 값을 사용하기 전에 (전달 받은 순간) 함수가 수행된 것
    그렇기 때문에 funA 가 먼저 출력되고, CallByValue 가 이후에 출력된다

    callByValue 개념은 함수가 인자로 전달될 때,
    이미 함수가 수행되어 결과값이 인자로 전달되는 것이다
 */



