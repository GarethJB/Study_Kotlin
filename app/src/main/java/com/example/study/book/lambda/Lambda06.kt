package com.example.study.book.lambda

// ◆ 람다식의 매개변수 ◆

// 파라미터 개수에 따라 람다식을 구성하는 방법
// 매개변수와 인자 개수에 따라 람다식의 생략된 표현이 가능


// ▶ 파라미터가 없는 람다식 ◀
// 파라미터가 없는 람다식이 noParam 함수의 파라미터 out 으로 지정됨
fun noParam(out: () -> String) = println(out())


// ▶ 파라미터가 1개 있는 람다식 ◀
// 파라미터가 1개 있는 람다식이 oneParam() 함수의 파라미터 out 으로 지정됨
fun oneParam(out: (String) -> String) {
    println(out("OneParam"))
}


// ▶ 파라미터가 2개 있는 람다식 ◀
// 파라미터가 2개 있는 람다식 moreParam 함수의 파라미터로 지정됨
fun moreParam(out: (String, String) -> String) {
    println(out("OneParam", "TwoParam"))
}


// ▶ 일반 파라미터와 람다식 파라미터를 같이 사용 ◀
// withArgs() 함수는 일반 파라미터 2개를 포함, 람다식을 마지막 매개변수로 가짐
fun withArgs(a: String, b: String, out: (String, String) -> String) {
    println(out(a, b))
}


// ▶ 2개의 람다식을 파라미터로 가진 함수의 사용 ◀
fun twoLambda(first: (String, String) -> String, second: (String) -> String) {
    println(first("OneParam", "TwoParam"))
    println(second("OneParam"))
}

fun main() {

    // 파라미터가 없는 람다식
    noParam({ "Hello World!" })
    noParam{"Hello World!"} // 소괄호 생략 가능

    // 파라미터가 1개 있는 람다식
    // 매개변수가 1개인 경우에는 화살표 표기를 생략하고 it으로 대체할 수 있다
    oneParam({ a -> "Hello Wolrd! $a"})
    oneParam { a -> "Hello World! $a" } // 소괄호 생략 가능
    oneParam { "Hello World! $it" }     // it 으로 대체 가능

    // 파라미터가 2개 있는 람다식
    moreParam { a, b -> "Hello World! $a $b" }

    // 특정 람다식의 파라미터를 사용하고 싶지 않을 때
    moreParam{ _, b -> "Hello World! $b" }  // 파라미터명 대신에 _ 로 대체

    // 인자와 함께 람다식을 사용하는 경우
    withArgs("Arg1", "Arg2", { a, b -> "Hello World! $a $b"})
    // withArgs() 함수의 마지막 인자가 람다식인 경우 소괄호 바깥으로 분리 가능
    withArgs("Arg1", "Arg2") { a, b -> "Hello World! $a $b"}

    // 2개의 람다식을 파라미터로 사용한 함수의 경우
    // 마지막 람다식만 소괄호에서 빼내서 구성할 수 있다
    twoLambda({ a, b -> "First $a $b" }, { "Second $it" })
    twoLambda({ a, b -> "First $a $b" }) { "Second $it" }   // 위와 동일

    // 람다식이 3개 있을 경우 → ({첫 번째}, {두 번째}) {세 번째}



}

