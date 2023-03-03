package com.example.study.book.property

import android.text.BoringLayout


// ◆ lazy 를 사용한 지연 초기화 ◆


/*  ▶ lazy 의 특징

    - 호출 시점에 by lazy {...} 정의에 의해 블록 부분의 초기화를 진행한다
    - 불변의 변수 선언인 val 에서만 사용 가능하다
    - val 이므로 값을 다시 변경할 수 없다                                    */


// lazy 는 람다식으로 구성되어 lazy 인스턴스 반환값을 가지는 함수다

// by lazy 로 선언된 프로퍼티 지연 초기화
class LazyTest {
    init {
        println("init block")   // ②
    }

    val subject by lazy {
        println("lazy initialized") // ⑥
        "Kotlin Programming"    // ⑦ lazy 반환값
    }
    fun flow() {
        println("not initialized")  // ④
        println("subject one: $subject")    // ⑤ 최초 초기화 시점
        println("subject two: $subject")    // ⑧ 이미 초기화된 값 사용
    }
}


// 객체 지연 초기화
class PersonLazy(val name: String, val age: Int)


fun main() {

    // 프로퍼티 지연 초기화
    val test = LazyTest()   // ①
    test.flow() // ③


    // 객체 지연 초기화
    var isPersonLazyInstantiated: Boolean = false   // 초기화 확인 용도

    val person : PersonLazy by lazy {   // ① lazy 를 사용한 person 객체의 지연 초기화
        isPersonLazyInstantiated = true
        PersonLazy("Kim", 23)   // ② 이 부분이 Lazy 객체로 반환됨
    }
    val personDelegate = lazy { PersonLazy("Hong", 40)} // ③ 위임 변수를 사용한 초기화

    println("person Init: $isPersonLazyInstantiated")
    println("personDelegate Init: ${personDelegate.isInitialized()}")

    println("person.name = ${person.name}") // ④ 이 시점에서 초기화
    println("personDelegate.value.name = ${personDelegate.value.name}") // ⑤ 이 시점에서 초기화

    println("person Init: $isPersonLazyInstantiated")
    println("personDelegate Init: ${personDelegate.isInitialized()}")

}
