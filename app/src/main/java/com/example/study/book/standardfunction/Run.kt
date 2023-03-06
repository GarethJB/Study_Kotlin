package com.example.study.book.standardfunction




// ◆ run() 함수 활용 ◆

// run() 함수는 인자가 없는 익명 함수처럼 동작하는 형태와
// 객체에서 호출하는 형태, 2가지로 사용할 수 있다
//public inline fun <R> run(block: () -> R): R = return block()
//public inline fun <T, R> T.run(block: T.() -> R): R = return block()

// run() 에서는 block 이 독립적으로 사용되며
// 이어지는 block 냐에서 처리할 작업을 넣어 줄 수 있고
// 일반 함수와 마찬가지로 값을 반환하지 않거나 특정 값을 반환할 수 있다

fun main() {

    var skills = "Kotlin"
    println(skills) // Kotlin

    val a = 10
    skills = run {
        val level = "Kotlin Level:" + a
        level   // 마지막 표현식이 반환됨
    }
    println(skills) // Kotlin Level:10

    data class Person(var name: String, var skills : String)
    var person = Person("홍길동", "Kotlin")
    val returnObj = person.apply {
        this.name = "Sean"
        this.skills = "Java"
        "success"   // 사용되지 않음
    }
    println(person)
    println("returnObj: $returnObj")
    val returnObj2 = person.run {
        this.name = "심청"
        this.skills = "C#"
        "success"
    }
    println(person)
    println("returnObj2: $returnObj2")
}