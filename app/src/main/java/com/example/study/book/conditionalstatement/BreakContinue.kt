package com.example.study.book.conditionalstatement



// ◆ break & continue ◆

// break : 사용한 지점에서 반복문을 빠져 나옴
// continue : 본문을 계속 진행하지 않고 다시 반복 조건으로 이동

fun main() {

    // break 사용
    for (i in 1..5) {
        if (i == 3) break
        print(i)
    }
    println()
    println("outside")

    println()

    // continue 사용
    for (i in 1..5) {
        if (i == 3) continue
        print(i)
    }
    println()
    println("outside")

    println()

    // break 에 라벨 사용
    labelBreak()

    println()

    // continue 에 라벨 사용
    labelContinue()
}


// break 에 라벨 사용
fun labelBreak() {
    println("labelBreak")
    first@for (i in 1..5) {
        second@for (j in 1..5) {
            if (j == 3) break@first
            println("i:$i, j:$j")
        }
        println("after for j")
    }
    println("after for i")
}



// continue 에 라벨 사용
fun labelContinue() {
    println("labelBreak")
    first@for (i in 1..5) {
        second@for (j in 1..5) {
            if (j == 3) continue@first
            println("i:$i, j:$j")
        }
        println("after for j")
    }
    println("after for i")
}

