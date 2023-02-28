package com.example.study.book.lambda



fun main() {
    cal(1, 3) { x, y -> x + y }
}

fun cal(a: Int, b: Int, c: (Int, Int) -> Int) {
    println(c(a, b))
}