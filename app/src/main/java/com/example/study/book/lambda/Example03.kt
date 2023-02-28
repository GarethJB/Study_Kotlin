package com.example.study.book.lambda

fun Calculator(a: Int, b: Int, p: (Int, Int) -> Int) {
    println("$a, $b : ${p(a,b)}")
}

fun main() {

    Calculator(1, 2) { a, b -> a + b}


}