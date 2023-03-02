package com.example.study.note


// ▶ 1급 객체
/*  1급 객체의 조건
    - 객체의 인자로 전달 할 수 있어야 한다
    - 객체의 반환값으로 전달 할 수 있어야 한다
    - 자료구조에 넣을 수 있어야 한다 */

/*  ① 객체의 인자로 전달할 수 있어야 한다  */
fun firstClassCitizenTest1(param: () -> Unit) {
    param()
}
// input 은 없고 return 이 Unit 인 함수를 파라미터로 받는 함수

/*  ② 객체의 반환값으로 반환 할 수 있어야 한다  */
fun firstClassCitizenTest2(): () -> Unit {
    return { println("Hello, World!") }
}
// Hello, World! 를 축력하는 함수를 리턴해주는 함수 → 리턴타입이 함수
// -> 람다식의 화살표가 보이면 함수라고 생각하는 것이 편하다
// A -> B  → A가 input 파라미터, B가 output

/*  ③ 자료구조에 넣을 수 있어야 한다  */
fun firstClassCitizenTest3(): () -> Unit {
    return {println("Hello, World!")}
}

val value = firstClassCitizenTest3()




// ▶ 고차함수
/*  함수를 파라미터로 전달받거나, 함수를 리턴하는 함수
    조건이 성립하려면 기본적으로 함수가 1급 객체여야 한다                  */
fun sum(a: Int, b: Int) : Int {
    return a+b
}

fun simpleHighOrderFunction(sum: (Int, Int) -> Int, a: Int, b: Int): Int {
    return sum(a, b)
}   // simpleHighOrderFunction 는 파라미터로 함수를 받았으므로 고차함수이다




// ▶ 순수함수
/*  횟수에 관계없이 언제나 같은 입력에 같은 출력값이 나오는 함수
    순수함수는 비순수함수 보다 안전하다                               */

fun pureFunction(str: String): String = str + "Test"    // 순수함수의 예

val sb = StringBuilder()
fun nonPureFunction(str: String): String = str + sb.append("Test").toString()   // 비순수함수의 예

