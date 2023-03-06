package com.example.study.book.array



// ◆ 멤버 메소드를 통한 배열 순환 ◆

// 배열의 멤버 메소드인 forEach() 와 forEachIndexed() 를 사용해 요소를 순환할 수 있다

// forEach() 는 요소 개수만큼 지정한 구문을 반복 실행
// forEachIndexed() 는 순환하며 인덱스까지 출력

fun main() {

    val arrCycle = Array<Any>(5, init = {1})
    arrCycle[2] = "String"
    arrCycle[4] = 4.23

    // forEach() 에 의한 요소 순환
    arrCycle.forEach { element -> println("$element") }

    // forEachIndexed() 에 의한 요소 순환
    arrCycle.forEachIndexed({i, e -> println("arr[$i] = $e") })

}