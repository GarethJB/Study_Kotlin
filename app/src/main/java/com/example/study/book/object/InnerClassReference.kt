package com.example.study.book.`object`

// ◆ 바깥 클래스 호출 ◆

// 이너 클래스에서 바깥 클래스의 상위 클래스를 호출하려면
// super 키워드와 함께 @ 기호 옆에 바깥 클래스 이름을 작성한다

open class Base {
    open val x: Int = 1
    open fun f() = println("Base class f()")
}

class Child : Base() {
    override val x: Int = super.x + 1
    override fun f() = println("Base class f()")
    inner class Inside {
        fun f() = println("Inside Class f()")
        fun test() {
            f() // ① 현재 이너 클래스의 f() 접근
            Child().f() // ② 바로 바깥 클래스 f() 접근
            super@Child.f() // ③ Child 의 상위 클래스인 Base 클래스의 f() 접근
            println("[Inside] super@Child.x: ${super@Child.x}") // ④ Base의 x 접근
        }
    }
}

// Child 클래스는 Base 클래스를 상속하고 있다
// Child 클래스 안에 inner 키워드로 선언된 이너 클래스인 Inside 클래스가 있다
// Inside 클래스의 객체를 생성하고 test() 메소드를 호출 → c1.Inside().test()
// Child 클래스로 생선한 객체인 c1 에 이너 클래스인 Inside() 에 생성자 표기로 접근하고
// 다시 test() 메소드에도 각각 점(.)으로 접근한다


fun main() {
    val c1 = Child()
    c1.Inside().test()
}