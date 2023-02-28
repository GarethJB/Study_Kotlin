package com.example.study.book.lambda


// ◆ 람다식을 인자나 반환값으로 사용하는 고차함수 ◆


fun main() {

    // 변수에 할당하는 람다식 함수 작성하기
    var result: Int
    val multi = {x: Int, y: Int -> x * y}
    result = multi(10, 20)
    println("multi result : $result")


    // 만약 함수 내용에 표현식이 2줄 이상이라면 마지막 표현식이 반환값이 된다
    val multi2: (Int, Int) -> Int = {x: Int, y: Int ->
        println("x * y")
        x * y }
    result = multi2(10, 10)
    println("multi2 result : $result")


    // 매개변수에 자료형이 지정되어 있다면 변수의 자료형은 생략할 수 있다
    // 다음 예시는 모두 같은 표현
    val exp1: (Int, Int) -> Int = {x: Int, y: Int -> x * y} // 생략되지 않은 전체 표현
    val exp2 = {x: Int, y: Int -> x * y}                    // 선언 자료형 생략
    val exp3: (Int, Int) -> Int = {x, y -> x * y}           // 람다식 매개변수 자료형의 생략


    // 반환 자료형이 없거나 매개변수가 하나만 있을 때
    val greet: () -> Unit = {println("Hello World!")}
    val square: (Int) -> Int = {x -> x * x}


    // 람다식 안에 람다식을 넣을 경우 자료형 지정
    val nestedLambda: () -> () -> Unit = {{println("nested")}}

    result = highOrder({x, y -> x + y}, 10, 20)
    println("highOrder result : $result")


    // 인자와 반환값이 없는 람다식 함수
    val out: () -> Unit = { println("Hello World!") }   // 인자와 반환값이 없는 람다식의 선언
    // 자료형 추론이 가능하므로 val out = {println("Hello World!")} 와 같이 생략 가능
    out()   // 함수처럼 사용 가능
    val new = out   // 람다식이 들어 있는 변수를 다른 변수에 할당
    new()

}

// 매개변수에 람다식 함수를 이용한 고차함수
fun highOrder(sum: (Int, Int) -> Int, a: Int, b: Int): Int {
    return sum(a, b)
}



