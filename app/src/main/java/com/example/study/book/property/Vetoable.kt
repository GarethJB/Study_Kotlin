package com.example.study.book.property

import kotlin.properties.Delegates


// ◆ vetoable() 함수 ◆

// 프로퍼티를 감시하고 있다가 특정 코드의 로직에서 변경이 일어날 때 호출되어 처리
// 리턴값에 따라 프로퍼티 변경을 허용하거나 취소할 수 있다

// 컬렉션과 같이 큰 데이터를 다룰 때 유용하다

// vetoable() 함수를 사용하여 최대값 구하기
fun main() {
    var max: Int by Delegates.vetoable(0) { // ① 초기값은 0
        prop, old, new ->
        new > old   // ② 조건에 맞지 않으면 거부
    }

    println(max)    // 0
    max = 10
    println(max)    // 10

    // 여기서는 기존값이 새 값보다 크므로  false → 5는 재할당 되지 않음
    max = 5
    println(max)    // 10


}