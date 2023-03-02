package com.example.study.book.conditionalstatement



// ◆ 예외 처리 ◆

// 해당 코드가 제대로 작동하지 못하고 중단되는 현상을 예외 Exception 라고 한다
// 프로그램을 실행할 때 발생할 수 있는 예외에 대비해야 하는데 이것을 예외 처리 라고 한다

// try 블록에서 예외가 발생하면 catch 블록에서 잡아서 그 예외를 처리한다

/*
    try {
        [예외 발생 가능성 있는 코드]
    } catch (e: [예외 처리 클래스]) {
        [예외를 처리하기 위한 코드]
    } finally {
        [반드시 실행되어야 하는 코드]
    }
 */

fun main() {
    val a = 6
    val b = 0
    val c : Int

    try {
        c = a/b // 0 으로 나눔
    } catch (e : ArithmeticException) { // 특정 예외를 잡아 처리
        //println("Exception in handled. ${e.message}")
        e.printStackTrace() // 스택을 추적하여 예외 처리 클래스와 오류가 발생한 코드를 확인
    } finally {
        println("finally 블록은 반드시 항상 실행됨")
    }
}