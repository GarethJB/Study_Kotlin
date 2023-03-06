package com.example.study.book.generic




// ◆ 람다식에서 제네릭 사용 ◆

// 형식 매개변수로 선언된 함수의 매개변수를 연산 → 자료형을 결정할 수 없으므로 오류

// 람다식을 매개변수로 받으면 람다식을 본문으로 넘겨줄 때 자료형이 결정됨

fun <T> add(a: T, b: T, op: (T, T) -> T): T {
    return op(a, b)
}

fun main() {
    //val result = add(2, 3, {a, b -> a + b}) // 같은 표현
    val result = add(2, 3) {a, b -> a + b}
    // 람다식 {a, b -> a + b} 는 add() 함수가 실행될 때 넘겨진다
    println(result)

    // 람다식만 변수로 따로 정의해 함수에 넣기
    val sumInt: (Int, Int) -> Int = {a, b -> a + b} // 변수 선언부가 있는 경우 표현식의 자료형 생략
    val sumInt2 = {a: Int, b: Int -> a + b} // 변수 선언부가 생략된 경우에는 표현식에 자료형 표기
    println(add(2, 3, sumInt))
    println(add(2, 3, sumInt2))
}

// 람다식 매개변수를 가독성 있게 단순화하기 위해서는 typealias 를 사용
typealias arithmetic<T> = (T, T) -> T
fun <T> addAux(a: T, b: T, op: arithmetic<T>): T {
    return op(a, b)
}