package com.example.study.book.property



// ◆ by 를 사용한 위임 ◆


// 프로퍼티의 Getter 와 Setter 를 특정 객체에게 위임하고
// 그 객체가 값을 읽거나 쓸 때 수행하도록 만드는 것

// <val|var|class> 프로퍼티 혹은 클래스 이름: 자료형 by 위임자

// 코틀린이 가지고 있는 라이브러리는 open 으로 정의되지 않은 클래스 → final 형태의 클래스
// 필요한 경우에만 위임을 통해 상속과 비슷하게 해당 클래스의 모든 기능을 사용
// 동시에 기능을 추가 확장 구현할 수 있다

// 클래스의 위임 사용하기
interface Car {
    fun go(): String
}

class VanImpl(val power: String): Car {
    override fun go() = "은 짐을 적재하며 $power 을 가집니다."
}

class SportImpl(val power: String): Car {
    override fun go() = "은 경주용에 사용되며 $power 을 가집니다"
}

class CarModel(val model: String, impl: Car): Car by impl {
    fun carInfo() {
        println("$model ${go()}")   // ① 참조 없이 각 인터페이스 구현 클래스의 go() 에 접근
    }
}

fun main() {
    val myKia = CarModel("K5 2010", VanImpl("100마력"))
    val my305z = CarModel("350Z 2007", SportImpl("350마력"))

    myKia.carInfo() // ② carInfo 에 대한 다형성을 나타냄
    my305z.carInfo()
}


/*  ※ 프로퍼티의 위임과 by lazy
    ① lazy 람다식은 람다식을 전달받아 저장한 Lazy<T> 인스턴스를 반환한다
    ② 최초 프로퍼티의 Getter 실행은 lazy 에 넘겨진 람다식을 실행하고 결과를 기록한다
    ③ 이후 프로퍼티의 Getter 실행은 이미 초기화되어 기록된 값을 반환한다                  */

// by lazy 에 의한 지연 초기화는 스레드에 좀 더 안정적으로 프로퍼티를 사용할 수 있다
// ex) 프로그램 시작 시 큰 객체가 있다면 초기화할 때 모든 내용을 시작 시간에 할당하므로 느려진다
// 이것을 필요에 따라 해당 객체를 접근하는 시점에서 초기화하면
// 시작할 때 마다 프로퍼티를 생성하느라 소비되는 시간을 줄일 수 있다




