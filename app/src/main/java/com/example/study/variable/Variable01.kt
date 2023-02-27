package com.example.study

fun main() {

    // ◆ 변수 선언 ◆

    val username: String = "임주빈"
    // [키워드] [변수명]: [자료형] = [값]

    val test1: String = "홍길동"    // val : 초기화 이후 변경이 불가능한 읽기 전용 변수가 됨

    var test2: String = "박문수"    // var : 초기화 이후에도 값을 변경할 수 있음
    test2 = "김문수"

    var test3 = "심청"    // 코틀린이 자료형을 추론하여 test3의 자료형을 String으로 결정

    //var test4 → 값을 할당하지 않은 변수의 자료형은 추론할 수 없음
    var test4: String // 나중에 값을 할당하려면 자료형을 지정
    test4 = "이몽룡"

    println("test1 : $test1")
    println("test2 : $test2")
    println("test3 : $test3")
    println("test4 : $test4")
}