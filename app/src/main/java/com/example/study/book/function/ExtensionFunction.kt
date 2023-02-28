package com.example.study.book.function


//  ▶ 확장 함수 ◀
//  확장함수는 클래스처럼 필요로 하는 대상에 함수를 더 추가할 수 있는 함수이다
//  최상위 클래스인 Any 에 확장함수를 구현하면 코틀린의 모든 클래스에 확장 함수를 추가할 수 있다
//  Any 에 확장 함수를 추가하면 코틀린의 모든 요소에 상속된다


// String 클래스에 확장 함수 추가하기

fun main() {

    val source = "Hello World!"
    val target = "Kotlin"
    println(source.getLongString(target))

}

// String 클래스를 확장해 getLongString() 함수 추가
fun String.getLongString(target: String): String =
    if (this.length > target.length) this else target

// 확장 대상에 점(.) 표기로 String.getLongString() 과 같이 선언해
// 기존에 없는 새로운 멤버 메소드를 만드는 것
// this.length 의 this 는 확장 대상에 있던 자리의 문자열인 source 객체를 나타낸다
// 확장 함수를 만들 때 확장하려는 대상에 동일한 이름의 멤버 함수 혹은 메소드가 존재한다면
// 항상 확장 함수보다 멤버 메소드가 우선으로 호출된다