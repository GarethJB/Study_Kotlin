package com.example.study.book.`object`

/*
    ◆ 다형성 ◆

    이름이 동일하지만 파라미터가 서로 다른 형태를 취하거나
    실행결과를 다르게 가질 수 있는 것을 다형성이라고 한다

    오버로딩 Overloading : 동작은 동일하지만 인자의 형식만 달라지는 것

    오버라이딩 Overriding : 메소드나 프로퍼티의 이름은 같지만 기존의 동작을 다른 동작으로 재정의 하는 것

 */

// ▶ 오버로딩 ◀
class Calc {
    // 다양한 파라미터로 오버로딩된 메소드
    fun add(x: Int, y: Int): Int = x + y
    fun add(x: Double, y: Double): Double = x + y
    fun add(x: Int, y: Int, z: Int): Int = x + y + z
    fun add(x: String, y: String): String = x + y
}


// ▶ 오버라이딩 ◀
// 하위클래스에서 새로 만들어지는 메소드가
// 이름이나 파라미터, 리턴값이 이전 메소드와 똑같지만 새로 작성되는 것
// 하위의 새로운 메소드는 상위 클래스의 메소드의 내용을 새로 만들어 다른 기능을 하도록 정의
// 즉, 재정의 한다라고도 할 수 있다

// 기반 클래스의 내용을 파생 클래스가 오버라이딩하기 위해
// 기반 클래스에서는 open 키워드,
// 파생 클래스에서는 override 키워드를 각각 사용해야 한다

// 코틀린에서는 메소드뿐만 아니라 프로퍼티도 오버라이딩 할 수 있다

// 상속 가능한 클래스를 위해 open 키워드를 사용
open class BirdOverride(var name: String, var wing: Int, var beak: String, var color: String) {
    // 메소드
    fun fly() = println("Fly wing: $wing")  // 최종 메소드로 오버라이딩 불가
    open fun sing(vol: Int) = println("Sing vol: $vol") // 오버라이딩 가능한 메소드 → open 키워드 사용
}

class ParrotOverride(name: String,
             wing: Int = 2,
             beak: String,
             color: String,
             // 마지막 인자만 var 로 선언되어 프로퍼티가 추가되었음을 알 수 있음
             var language: String = "natural") : BirdOverride(name, wing, beak, color) {

                 fun speak() = println("Speak! $language")  // ParrotOverride 에 추가된 메소드
                 override fun sing(vol: Int) {  // 오버라이딩된 메소드
                     println("I'm a parrot! The volume level is $vol")
                     speak()    // 달라진 내용
                 }
             }


fun main() {

    // 오버로딩된 메소드 출력
    val calc = Calc()
    println(calc.add(3, 2))
    println(calc.add(3.2, 1.3))
    println(calc.add(3, 3, 2))
    println(calc.add("Hello", "World"))

    // 오버라이딩된 메소드 출력
    val parrot = ParrotOverride(name = "myParrot", beak = "short", color = "multipe")
    parrot.language = "English"

    println("Parrot: ${parrot.name}, ${parrot.wing}, ${parrot.beak}, ${parrot.color}, ${parrot.language}")
    parrot.sing(5)  // 달라진 메소드 실행 가능

}