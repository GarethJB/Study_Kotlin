package com.example.study.note


// ▶ Call by Name
/*  함수가 함수의 인자로 전달될 때 바로 수행되지 않고,
    파라미터로 전달된 함수가 실제로 호출이 되는 시점에 수행되는 개념    */

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        callByName(funA)
        // funA 를 파라미터로 전달

    }

    fun callByName(f: () -> Boolean): Boolean {
        // 값이 아닌 함수를 인자로 전달받았다
        println("callByName")
        return f()
    }

    val funA: () -> Boolean = {
        println("funA")
        true
    }
}