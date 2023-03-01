package com.example.study.book.`object`

import org.intellij.lang.annotations.Language

/*
    ◆ 상속 ◆

    자식 클래스가 부모 클래스의 속성과 기능을 물려받아 계승하는 것

    코틀린의 모든 클래스는 Any 클래스의 하위 클래스가 되며,
    상위 클래스를 명시하지 않으면 Any 클래스를 상속받게 된다
    즉, 아무런 표기가 없더라도 모든 클래스는 Any 를 최상위 클래스로 가진다

    open class [기반 클래스] {   // 묵시적으로 Any 로부터 상속, open 으로 파생 가능
        ...
    }
    class [파생 클래스] : [기반 클래스]() {   // 기반 클래스로부터 상속, 최종 클래스로 파생 불가
        ...
    }

    // 클래스 이름 오른쪽에 소괄호나 블록의 유무에 따라 변순 서언과 클래스 상속을 구분할 수 있다

 */

val iVal: Int = 2    // 일반 변수의 선언
open class BaseClass(someArgs: Int) // 상속 가능한 클래스
class SomeClass(someArgs: Int) : BaseClass(someArgs)    // 클래스 상속의 선언
//class SomeClass2 : BaseClass { ..constructor().. }   // 부 생성자를 사용할 때 클래스 상속 선언\1q644440O
// 클래스의 선언부에는 : [콜론] 앞뒤로 공백을 둔다 → 변수 선언과 구분하기 위한 코딩 관례


// ① 상속 가능한 클래스를 선언하기 위해 open 사용
open class BirdInheritance(var name: String, var wing: Int, var beak: String, var color: String) {
    // 메소드
    fun fly() = println("Fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}

// ② 주 생성자를 사용하는 상속
class Lark(name: String, wing: Int, beak: String, color: String) : BirdInheritance(name, wing, beak, color){
    fun singHighTone() = println("Happy Song!") // 새로 추가한 메소드
}

// ③ 부 생성자를 사용하는 상속
class Parrot : BirdInheritance {
    val language: String
    constructor(name: String, wing: Int, beak: String, color: String, language: String) : super(name, wing, beak, color) {
        this.language = language    // 새로 추가한 프로퍼티
    }

    fun speak() = println("Speak! $language")
}

fun main() {
    val coco = BirdInheritance("myBird", 2, "short", "blue")
    val lark = Lark("myLark", 2, "long", "brown")
    val parrot = Parrot("myParrot", 2, "short", "multiple", "korean")   // 프로퍼티 추가

    println("Coco: ${coco.name}, ${coco.wing}, ${coco.beak}, ${coco.color}")
    println("Lark: ${lark.name}, ${lark.wing}, ${lark.beak}, ${lark.color}")
    println("Parrot: ${parrot.name}, ${parrot.wing}, ${parrot.beak}, ${parrot.color}, ${parrot.language}")
    lark.singHighTone() // 새로 추가한 메소드 사용 가능
    parrot.speak()
    lark.fly()

}




