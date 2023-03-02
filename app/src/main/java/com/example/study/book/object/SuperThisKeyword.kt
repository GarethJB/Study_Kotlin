package com.example.study.book.`object`

/*
    ◆ super 와 this 의 참조 ◆

    상위와 현재 클래스의 특정 메소드, 프로퍼티, 생성자를 참조해야 하는 경우 사용

    super 키워드는 상위 클래스를 참조
    this 키워드는 현재 클래스를 참조

    super.프로퍼티  // 상위 클래스의 프로퍼티 참조
    super.메소드()  // 상위 클래스의 메소드 참조
    super()         // 상위 클래스의 생성자 참조

    this.프로퍼티   // 현재 클래스의 프로퍼티 참조
    this.메소드()   // 현재 클래스의 메소드 참조
    this()          // 현재 클래스의 생성자 참조

 */

// ▶ super 키워드로 상위 객체 참조 ◀

// 메소드를 오버라이딩할 때 만약 상위 클래스에서 구현한 내용을 그대로 사용하고
// 거기에 필요한 내용만 추가하려고 한다 → super 키워드 사용

open class BirdSuper(var name: String, var wing: Int, var beak: String, var color: String) {
    fun fly() = println("Fly wing: $wing")
    open fun sing(vol: Int) = println("Sing vol: $vol")
}

class ParrotSuper(name: String, wing: Int = 2, beak: String, color: String,
                    var language: String = "natural") : BirdSuper(name, wing, beak, color) {
                        fun speak() = println("Speak! $language")

                        override fun sing(vol: Int) { // ① 상위 클래스의 내용과 다르게 새로 구현된 내용을 가짐
                            super.sing(vol) // 상위 클래스의 sing()을 먼저 수행
                            println("I'm a parrot! The volume level is $vol")
                            speak()
                        }
                    }


// ▶ this 로 현재 객체 참조하기 ◀
// this 와 super 를 사용하는 부 생성자
open class Person {
    constructor(firstName: String) {
        println("[Person] firstName: $firstName")
    }

    constructor(firstName: String, age: Int) {
        println("[Person] firstName: $firstName, $age")
    }
}

class Developer: Person {
    constructor(firstName: String): this(firstName, 10) {
        println("[Developer] $firstName")
    }
    constructor(firstName: String, age: Int): super(firstName, age) {
        println("[Developer] $firstName, $age")
    }
}

// ▶ 주 생성자와 부 생성자 함께 사용하기 ◀
// 주 생성자와 부 생성자가 함께 있다면 this 키워드를 사용해서 주 생성자를 가리킬 수 있다
class PersonTogether(firstName: String, out: Unit = println("[Primary Constructor] Parameter")) {   // ② 주 생성자

    val fName = println("[Property] PersonTogether fName: $firstName")  // ③ 프로퍼티 할당

    init {
        println("[init] Person init block") // ④ 초기화 블록
    }

    // ① 부 생성자
    constructor(firstName: String, age: Int, out: Unit = println("[Secondary Constructor] Parameter")): this(firstName) {
        println("[Secondary Constructor] Body: $firstName, $age")   // ⑤ 부 생성자 본문
    }
}


fun main() {

    // super 키워드로 상위 객체 참조
    val parrot = ParrotSuper(name = "myParrot", beak = "long", color = "blue")
    parrot.sing(3)

    println()

    // this 키워드로 현재 객체 참조
    val sean = Developer("Sean")

    println()

    // 주 생성자와 부 생성자 함께 사용
    val p1 = PersonTogether("홍길동", 30)  // ① → ② 호출, ③ → ④ → ⑤ 실행
    println()
    val p2 = PersonTogether("심청")    // ② 호출, ③ → ④ 실행
}




