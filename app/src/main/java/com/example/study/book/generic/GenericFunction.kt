package com.example.study.book.generic



// ◆ 제네릭 함수 ◆

// 형식 매개변수를 받는 함수
// 함수 앞쪽에 <T> 와 같이 형식 매개변수를 지정
// <K, V> 와 같이 형식 매개변수를 여러 개 사용할 수 있다

// fun <형식 매개변수[,...]> 함수명(매개변수: <매개변수 자료형>[, ...]): <반환 자료형>
//fun <T> genericFunc2(arg: T): T? {...} → 매개변수와 반환 자료형에 형식 매개변수 T가 사용됨
//fun <K, V> put(key: K, value: V): Unit {...} → 형식 매개변수가 2개인 경우


// 배열의 인덱스 찾아내기
fun <T> find(a: Array<T>, Target: T): Int {
    for (i in a.indices) {
        if (a[i] == Target) return i
    }
    return -1
}

fun main() {
    val arr1: Array<String> = arrayOf("Apple", "Banana", "Cherry", "Durian")
    val arr2: Array<Int> = arrayOf(1, 2, 3, 4)

    println("arr.indices ${arr1.indices}")  // indices 는 배열의 유효 범위 반환
    println(find<String>(arr1, "Cheery"))   // 요소 C의 인덱스 찾아내기
    println(find(arr2, 2))  // 요소 2의 인덱스 찾아내기
}

// Array<T>는 배열을 위한 클래스로 arrayOf() 함수를 이용해 여러 개의 요소를 정의할 수 있다
