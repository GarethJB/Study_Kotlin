package com.example.study.book.variable



// ◆ 변수의 범위 ◆

/*  ▶ 전역 변수 Global Variable
    최상위에 있는 변수
    프로그램이 실행되는 동안 삭제되지 않고 메모리에 유지
    자주 사용되지 않는 전역 변수는 메모리 자원 낭비를 불러온다   */


/*  ▶ 지역 변수 Local Variable
    특정 코드 안에 있는 변수
    블록을 벗어나면 메모리에 더 이상 사용되지 않고 삭제된다      */

var global = 10 // 패키지 variable 의 모든 범위에 적용되는 전역 변수

fun main() {
    val local1 = 20 // main() 함수 블록 안에서만 유지되는 지역 변수
    val local2 = 21

    fun nestedFunc() {
        global += 1
        val local1 = 30 // func() 함수 블록 안에서만 유지 → 기존 local1 이 가려짐
        println("nestedFunc local1: $local1")
        println("nestedFunc local2: $local2")
        println("nestedFunc global: $global")
    }

    nestedFunc()
    outsideFunc()

    println("main global: $global")
    println("main local1: $local1")
    println("main local2: $local2")
}

fun outsideFunc() {
    global += 1
    val outVal = "outside"
    println("outsideFunc global: $global")
    println("outsideFunc outVal: $outVal")
}