package com.example.study.fastcampus.part1

fun main() {

    var x = 5
    while (x > 0) {
        println(x)
        x--
    } // 5 4 3 2 1

    x = 0
    while (x > 0) {
        println(x)
        x--
    } // 출력 없음

    var y = 0
    do {
        println(y)
        y--
    }while (y > 0)
    // 0

}