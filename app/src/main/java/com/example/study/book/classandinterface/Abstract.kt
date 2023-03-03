package com.example.study.book.`object`

/*
    ◆ 추상 클래스 ◆

    - 대략적인 설계의 명세와 공통의 기능을 구현한 클래스
    - 추상 클래스를 상속하는 하위 클래스는 추상 클래스의 내용을 구체화 해야함


    ▶ 추상 클래스와 인터페이스의 차이점
    - 추상 클래스에서는 프로퍼티의 초기화가 가능
    - 인터페이스에서는 프로퍼티의 초기화가 불가능
*/


// abstract 키워드를 사용해서 정의한다
// 추상 클래스는 상속을 위해 open 키워드를 사용할 필요 없다
// → abstract 키워드 자체가 상속과 오버라이딩을 허용하고 있기 때문
// 클래스 내에서의 프로퍼티나 메소드도 abstract 로 선언할 수 있다
// 만일 클래스에서 추상 프로퍼티나 메소드가 하나라도 있다면 해당 클래스는 추상 클래스가 되어야 한다

// abstract 로 정의한 추상 클래스이다. 주생성자를 사용했다.
abstract class Vehicle(val name : String, val color : String, val weight : Int) {
    // abstract 로 정의한 추상 프로퍼티이므로 하위 클래스에서 반드시 재정의해야한다.
    abstract var maxSpeed : Int

    // 초기값을 갖는 일반 프로퍼티 (인터페이스에서는 불가능)
    var year = "2021"

    // abstract로 정의한 추상 메소드이므로 하위 클래스에서 반드시 재정의해야한다.
    abstract fun start()
    abstract fun stop()

    fun displaySpecs() {
        println("Name : $name, Color : $color, Weight : $weight, Year : $year, MaxSpeed : $maxSpeed")
    }
}

// Vehicle 클래스는 abstract 로 정의한 추상 클래스이므로 기본적인 설계만 정의하고 있다
// abstract 를 선언한 maxSpeed, start(), stop() 은 반드시 하위 클래스에서 재정의 해줘야 한다

class Car(name: String, color: String, weight: Int, override var maxSpeed: Int) : Vehicle(name, color, weight) {
    override fun start() {
        // 재정의
        println("Car start")
    }

    override fun stop() {
        // 재정의
        println("Car Stop")
    }
}

class Bicycle(name: String, color: String, weight: Int, override var maxSpeed: Int) : Vehicle(name, color, weight) {
    override fun start() {
        // 재정의
        println("Bicycle start")
    }

    override fun stop() {
        // 재정의
        println("Bicycle Stop")
    }
}



// 추상 클래스를 상속받는 하위 클래스를 정의하지 않고 추상 클래스를 사용 → object 키워드
abstract class Printer {
    abstract fun print()
}

val myPrinter = object : Printer() {
    override fun print() {
        println("print 메소드가 재정의되었습니다")
    }
}
// 추상 메소드 하나를 가지는 클래스인 Printer 는 객체 인스턴스를 지정하기 위해
// 익명 객체를 지정하는 object 키워드를 사용하였다
// 이 때는 콜론(:) 오른쪽에 생성자 이름을 사용하고 블록에서 관련 메소드를 오버라이딩해 구현해 두어야 함


fun main() {

    // Vehicle
    val car = Car("Matiz", "Yellow", 1000, 150)
    val bicycle = Bicycle("Bike", "Red", 150, 100)

    // 새로운 값 할당
    car.year = "2020"

    car.displaySpecs()
    car.start()
    bicycle.displaySpecs()
    bicycle.start()


    // Printer
    myPrinter.print()

}

