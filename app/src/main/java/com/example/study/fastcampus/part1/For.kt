package com.example.study.fastcampus.part1

fun main() {

    for (i in 1..5) {
        println(i)
    } // 1 2 3 4 5

    for (i in 6 downTo 0 step 2) {
        println(i)
    } // 6부터 시작해서 0까지 2씩 감소 → 6 4 2 0

    for (i in 1..5 step 3) {
        println(i)
    } // 1부터 시작해서 5까지 3씩 증가 → 1 4

    val numberList = listOf(100, 200, 300)
    for (number in numberList) {
        println(number)
    } // 100, 200, 300

}