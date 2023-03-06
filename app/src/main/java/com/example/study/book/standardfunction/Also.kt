package com.example.study.book.standardfunction

import java.io.File


// ◆ also() 함수 ◆

// also() 함수는 함수를 호출하는 객체 T 를 이어지는 block 에 전달하고 객체 T 자체를 반환한다

// 선언부의 let() 함수와 also() 함수의 차이
//public inline fun <T, R> T.let(block: (T) -> R): R = block(this)
public inline fun <T> T.also(block: (T) -> Unit): T {block(this); return this}
// let() 함수는 마지막으로 수행된 코드 블록의 결과를 반환
// also() 함수는 블록 안의 코드 수행 결과와 상관없이 T인 객체 this 를 반환

fun main() {

    // 예제
    var m = 1
    m = m.also { it + 3 }
    println(m)  // 원본 값 1
    // 연산 결과인 4가 m 에 할당되는 것이 아니라 it 의 원래의 값 1이 다시 m 에 할당된다

    data class Person(var name: String, var skills: String)
    var person = Person("홍길동", "Kotlin")
    val a = person.let {
        it.skills = "Android"
        "success"   // 마지막 문장을 결과로 반환
    }
    println(person)
    println("a: $a")    // String
    val b = person.also {
        it.skills = "Java"
        "success"   // 마지막 문장은 사용되지 않음
    }
    println(person)
    println("b: $b")    // Person 의 객체 b
}


// 기존 디렉토리 생성 함수
fun makeDir(path: String): File {
    val result = File(path)
    result.mkdirs()
    return result
}

// let() 과 also() 를 통해 개선된 함수
fun makeDir2(path: String) = path.let{File(it)}.also { it.mkdirs() }
