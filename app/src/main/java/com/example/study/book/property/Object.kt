package com.example.study.book.property



// ◆ object 와 싱글톤 ◆

// object 로 선언되면 멤버 프로퍼티와 메소드를 객체 생성 없이
// 이름의 점(.) 표기법으로 바로 사용할 수 있다

// 단일 인스턴스를 생성해 처리하기 때문에 싱글톤 패턴에 이용된다

// object 선언 방식을 사용하면 접근 시점에 객체가 생성된다
// 생성자 호출을 하지 않으므로 object 선언에는 주 생성자와 부 생성자를 사용할 수 없다
// 초기화 블록인 init{} 이 들어갈 수 있고, 최초 접근에서 실행된다
// object 선언에서도 클래스나 인터페이스를 상속할 수 있다
// 자바에서 object 선언으로 생성된 인스턴스에 접근하려면 INSTANCE 를 사용한다

// ▶ object 선언
// ① object 키워드를 사용한 방식
object OCustomer {
    var name = "홍길동"
    fun greeting() = println("Hello World!")
    val HOBBY = Hobby("Basketball")
    init {
        println("Init!")
    }
}

// ② 컴패니언 객체를 사용한 방식
class CCustomer {
    companion object {
        const val HELLO = "hello"   // 상수 표현
        var name = "심청"
        @JvmField val HOBBY = Hobby("Football")
        @JvmStatic fun greeting() = println("Hello World!")
    }
}

class Hobby(val name: String)


// ▶ object 표현식
// object 표현식은 object 선언과 달리 이름이 없고 싱글톤이 아니다
// object 표현식이 사용될 때마다 새로운 인스턴스가 생성됨
open class Superman() {
    fun work() = println("Taking photos.")
    fun talk() = println("Talking with people.")
    open fun fly() = println("Flying in the air.")
}

fun main() {

    // object 선언
    OCustomer.greeting()    // 객체의 접근 시점
    OCustomer.name = "박문수"
    println("name = ${OCustomer.name}")
    println(OCustomer.HOBBY.name)

    CCustomer.greeting()
    println("name = ${CCustomer.name}, HELLO = ${CCustomer.HELLO}")
    println(CCustomer.HOBBY.name)

    println()

    // object 표현식
    val pretendedMan = object: Superman() { // object 표현식으로 fly() 구현의 재정의
        override fun fly() = println("I'm not a real superman. I can't fly!")
    }

    pretendedMan.work()
    pretendedMan.talk()
    pretendedMan.fly()
}