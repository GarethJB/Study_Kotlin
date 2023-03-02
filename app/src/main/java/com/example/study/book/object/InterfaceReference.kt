package com.example.study.book.`object`


// ◆ 인터페이스에서 참조 ◆

// 인터페이스를 참조하는 클래스는 인터페이스가 가지고 있는 내용을 구현해야 하는 가이드를 제시한다
// 따라서, 인터페이스 자체로는 객체로 만들 수 없고 항상 인터페이스를 구현하는 클래스에서 생성해야 한다

open class A {
    open fun f() = println("A Class f()")
    fun a() = println("A Class a()")
}

interface B {
    fun f() = println("B Interface f()")    // 인터페이스는 기본적으로 open 이다
    fun b() = println("B Interface b()")
}

class C : A(), B {  // ① , (쉼표)를 사용해 클래스와 인터페이스를 지정
    // 컴파일되려면 f() 가 오버라이딩되어야 함
    override fun f() = println("C Class f()")

    fun test() {
        f() // ② 현재 클래스의 f()
        b() // ③ 인터페이스 B의 b()
        super<A>.f()    // ④ A 클래스의 f()
        super<B>.f()    // ⑤ B 클래스의 f()
    }
}

fun main() {
    val c = C()
    c.test()
}