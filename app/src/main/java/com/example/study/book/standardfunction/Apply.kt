package com.example.study.book.standardfunction

import android.widget.LinearLayout
import java.io.File


// ◆ apply() 함수 활용 ◆

// also 와 마찬가지로 호출하는 객체 T를 이어지는 block 으로 전달하고 객체 자체인 this 를 반환

public inline fun <T> T.apply(block: T.() -> Unit): T {block(); return this}

// apply() 함수는 특정 객체를 생성하면서 함께 호출해야 하는 초기화 코드가 있는 경우 사용

// also() 함수와 apply() 함수의 다른 점은 T.() 와 같은 표현에서 람다식이 확장 함수로 처리된다는 것

//apply() 함수 사용
fun main() {
    data class Person(var name: String, var skills : String)
    var person = Person("홍길동", "Kotlin")
        person.apply { this.skills = "Swift" }  // 여기서 this 는 person 객체를 가리킴
    println(person)

    val returnObj = person.apply {
        name = "Sean"   // this 는 생략 가능
        skills = "Java" // this 없이 객체의 멤버에 여러 번 접근
    }
    println(person)
    println(returnObj)
}

// apply() 함수는 person 객체를 this 로 받아온다
// 따라서 객체의 프로퍼티를 변경하면 원본 객체에 반영되고 또한 이 객체는 this 로 반환된다

// also() 함수에서는 it 을 생략할 수 없지만 apply() 함수에서는 this 가 생략된다

// 디렉토리 생성할 때 apply() 함수 활용
fun makeDir3(path: String) = File(path).apply { mkdirs() }