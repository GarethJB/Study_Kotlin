package com.example.study.book.generic



// ◆ 제네릭 클래스 데이터 형변환 ◆

// 제네릭 클래스는 가변성을 지정하지 않으면
// 형식 파라미터에 상·하위 클래스가 지정되어도 서로 자료형이 변환되지 않는다
open class Parent

class Child: Parent()

class Cup<T>

fun main() {
    val obj1: Parent = Child()  // Parent 형식의 obj1 은 Child 의 자료형으로 변환될 수 있음
    //val obj2: Child = Parent()    // 오류! 자로형 불일치

    //val obj3: Cup<Parent> = Cup<Child>()  // 오류! 자료형 불일치
    //val obj4: Cup<Child> = Cup<Parent>()  // 오류! 자료형 불일치

    val obj5 = Cup<Child>()    // obj5 는 Cup<Child> 의 자료형이 됨
    val obj6: Cup<Child> = obj5   // 자료형이 일치함
}



