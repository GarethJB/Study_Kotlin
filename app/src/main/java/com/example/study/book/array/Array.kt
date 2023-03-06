package com.example.study.book.array

import java.util.*


// ◆ 배열 ◆

// 동일한 자료형의 데이터를 연속적으로 나열한 형태
// 순서 번호에 해당하는 index 와 값이 들어있는 저장공간을 가지고 있다

// 코틀린에서는 이 요소에 여러 가지 자료형을 혼합해 구성할 수 있다

// 기본적인 배열의 생성은 arrayOf 나 Array() 생성자를 사용해 배열은 만든다
// 빈 상태의 배열을 지정하는 경우 arrayOfNulls() 를 사용할 수 있습니다

fun main() {

    val arr = intArrayOf(1, 2, 3, 4, 5)

    println("arr: ${Arrays.toString(arr)}") // Arrays.toString() 은 배열의 내용을 문자열로 변환
    println("size: ${arr.size}")    // size 는 배열의 크기를 나타냄
    println("sum: ${arr.sum()}")    // sum() 메소드는 배열의 합을 계산

    // Getter 에 의한 접근과 대괄호 연산자 표기법
    println(arr.get(2))
    println(arr[2])

    // Setter 에 의한 값의 설정
    arr.set(2, 7)
    arr[0] = 8
    println("size: ${arr.size} arr[0]: ${arr[0]}, arr[2]: ${arr[2]}")

    // 루프를 통한 배열 요소의 접근
    for (i in 0..arr.size -1) {
        println("arr[$i] = ${arr[i]}")
    }
}



