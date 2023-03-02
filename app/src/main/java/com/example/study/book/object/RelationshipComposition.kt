package com.example.study.book.`object`.relationship



/*  ▶ 구성 관계 Composition ◀

    특정 클래스가 어느 한 클래스의 부분이 되는 것
    구성품으로 지정된 클래스는 생명주기가 소유자 클래스에 의존되어 있다
    소유자 클래스가 삭제되면 구성하고 있던 클래스도 같이 삭제 된다             */

class Car(val name: String, val power: String) {
    private var engine = Engine(power)  // Engine 클래스 객체는 Car 에 의존적

    fun startEngine() = engine.start()
    fun stopEngine() = engine.stop()
}

class Engine(power: String) {
    fun start() = println("Engine has been started.")
    fun stop() = println("Engine has been stopped.")
}

fun main() {
    val car = Car("Kia", "100hp")
    car.startEngine()
    car.stopEngine()
}