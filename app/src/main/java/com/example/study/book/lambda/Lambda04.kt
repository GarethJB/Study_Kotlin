package com.example.study.book.lambda


// ◆ 람다식과 고차함수 호출 ◆

// ▶ 이름에 의한 람다식 호출 ◀

// 람다식의 이름이 인자로 전달될 때 실행되지 않고 실제로 호출할 때 실행되도록 하려면?

fun callByName(b: () -> Boolean): Boolean {  // 람다식 자료형으로 선언된 매개변수
    println("callByName function")
    return b()
}

val otherLambda: () -> Boolean = {
    println("otherLambda function")
    true
}

fun main() {
    val result = callByName(otherLambda)  // 람다식 이름으로 호출
    println(result)
}

/*

    1. callByName() 은 매개변수 b가 람다식 자료형으로 선언됨
    2. 따라서 람다식 이름을 callByName() 함수의 인자로 넣어 사용하고 있음
    3. 람다식 자체가 매개변수 b에 복사되어 사용되기 전까지 람다식이 실행되지 않음
    4. 함수 형태로 호출해야 람다식이 실행된다
    5. 이름이 전달된 시점이 아니라 callByName() 함수 블록에 사용되는 b() 에 의해 호출

    이것을 활용하면 상황에 맞춰 즉시 실행할 필요가 없는 코드를 작성하는 경우 이름에 의한 호출 방법을 통해
    필요할 때만 람다식이 작동하도록 만들 수 있다

*/