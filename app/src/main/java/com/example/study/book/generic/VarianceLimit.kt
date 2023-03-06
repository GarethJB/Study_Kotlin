package com.example.study.book.generic



// ◆ 공변성에 따른 자료형 제한 ◆

// 상위 클래스와 하위 클래스를 만들고 공변성에 따라 자료형을 제한

open class Animal(val size: Int) {
    fun feed() = println("Feeding...")
}

class Cat(val jump: Int): Animal(50)
class Spider(val poison: Boolean): Animal(1)

// ① 형식 매개변수를 Animal 로 제한
class BoxAnimal<out T: Animal>(val element: T) {    // 주 생성자에서는 val 만 허용
    fun getAnimal(): T = element    // ② out 은 반환 자료형에만 사용할 수 있음
    //fun set(new: T) {   // ③ 오류 → T 는 in 위치에 사용할 수 없음
    //    element = new
    //}
}

fun main() {

    // 일반적인 객체 선언
    val c1: Cat = Cat(10)
    val s1: Spider = Spider(true)

    var a1: Animal = c1 // 클래스의 상위 자료형으로 변환하는 것은 문제 없음
    a1 = s1 // ④ a1 은 Spider 의 객체가 됨
    println("a1.size = ${a1.size}")

    val c2: BoxAnimal<Animal> = BoxAnimal<Cat>(Cat(10)) // ⑤ 공변성 - Cat 은 Animal 의 하위 자료형
    println("c2.element.size = ${c2.element.size}")

    // val c3: BoxAnimal<Cat> = BoxAnimal<Animal>(10) // ⑥ 오류 → 반대의 경우는 인스턴스화 되지 않음
    // val c4: BoxAnimal<Any> = BoxAnimal<Int>(10)  // ⑦ 오류 → 자료형을 제한하여 Animal 과 항위 클래스 이외에는 사용할 수 없음
}

// out 을 사용하는 경우 형식 매개변수를 갖는 프로퍼티는 var 로 지정될 수 없고, val 만 허용
// var 를 사용하려면 다음과 같이 private 로 지정해야 한다
class BoxAnimal2<out T: Animal>(private var elem: T)