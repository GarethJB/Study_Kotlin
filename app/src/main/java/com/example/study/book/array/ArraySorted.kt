package com.example.study.book.array

import java.util.*


// ◆ 배열 정렬하기 ◆

// Array 는 기본적인 정렬 알고리즘을 제공한다

// 기본 배열 정렬하고 반환하기
// sortedArray() 와 sortedArrayDescending() 을 사용해 정렬된 배열을 반환한다
// 원본은 그대로 두고 정렬된 배열을 새로 할당할 때 사용

fun main() {

    val arrSorted = arrayOf(8, 4, 3, 2, 5, 9, 1)

    // ① 오름차순, 내림차순으로 정렬된 일반 배열로 반환
    val sortedNum = arrSorted.sortedArray()
    println("ASC: " + Arrays.toString(sortedNum))

    val sortedNumDesc = arrSorted.sortedArrayDescending()
    println("DEC: " + Arrays.toString(sortedNumDesc))

    // ② 원본 배열에 대한 정렬
    arrSorted.sort(1, 3)    // sort(fromIndex, toIndex)
    println("ORI:" + Arrays.toString(arrSorted))
    arrSorted.sortDescending()
    println("ORI:" + Arrays.toString(arrSorted))

    // ③ List 로 반환
    val listSorted: List<Int> = arrSorted.sorted()
    val listDesc: List<Int> = arrSorted.sortedDescending()
    println("LST: " + listSorted)
    println("LST: " + listDesc)

    // ④ SortBy 를 이용한 특정 표현식에 따른 정렬
    val items = arrayOf<String>("Dog", "Cat", "Lion", "Kangaroo", "Po")
    items.sortBy {item -> item.length}
    println(Arrays.toString(items))

}