package com.example.study.book.property

import kotlin.properties.Delegates


// ◆ observable() 함수 ◆

// 프로퍼티를 감시하고 있다가 특정 코드의 로직에서 변경이 일어날 때 호출되어 처리
// 특정 변경 이벤트에 따라 호출되므로 콜백이라고도 한다
// 코틀린 패키지의 Delegates 를 임포트 해야함

// observable() 함수 사용
class User {
    var name: String by Delegates.observable("NONAME") {    // ① 프로퍼티 위임
        prop, old, new ->   // ② 람다식 파라미터로 프로퍼티, 기존 값, 새로운 값 지정
        println("$old -> $new") // ③ 이 부분은 이벤트가 발생할 때만 실행
    }
}

fun main() {
    val user = User()
    user.name = "홍길동"   // ④ 값이 변경되는 시점에서 첫 이벤트 발생
    user.name = "심청"
// ⑤ 값이 변경되는 시점에서 두 번째 이벤트 발생
}