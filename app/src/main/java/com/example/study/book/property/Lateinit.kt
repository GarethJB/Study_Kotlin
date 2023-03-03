package com.example.study.book.property



// ◆ lateinit 에 의한 지연 초기화 ◆


/*  ▶ lateinit 의 제한

    - var 로 선언된 프로퍼티만 가능하다
    - 프로퍼티에 대한 Getter 와 Setter 를 사용할 수 없다            */

// 프로퍼티 지연 초기화
class Person {
    lateinit var name: String   // ① 지연 초기화를 위한 선언

    fun test() {
        if (!::name.isInitialized) {    // ② 프로퍼티의 초기화 여부 판단
            println("not initialized")
        }else {
            println("initialized")
        }
    }
}


// 객체 지연 초기화
// 생성자를 통해 객체를 생성할 때도 lateinit 을 사용해 필요한 시점에 객체를 지연 초기화할 수 있다
data class Person2(var name: String, var age: Int)

lateinit var person2: Person2   // 객체 생성의 지연 초기화


fun main() {

    // 프로퍼티 지연 초기화
    val person1 = Person()    // 객체를 생성해도 name 은 초기화 되지 않음
    person1.test()
    person1.name = "홍길동"  // ③ 이 시점에서 초기화됨 → 지연 초기화
    person1.test()
    println("name = ${person1.name}")


    // 객체 지연 초기화
    person2 = Person2("심청", 30) // 생성자 호출 시점에서 초기화됨
    println(person2.name + " is " + person2.age)
}