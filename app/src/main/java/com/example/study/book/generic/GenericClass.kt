package com.example.study.book.generic



// ◆ 제네릭 클래스 ◆

// 형식 파라미터를 1개 이상 받는 클래스
// 클래스를 선언할 때 데이터 타입을 특정하지 않고 인스턴스를 생성하는 시점에서 정하는 것

class MyClass<T> {  // 1개의 형식 파라미터를 가지는 클래스
    fun myMethod(a: T) {    // 메소드의 파라미터 데이터 타입에 사용됨
        /// ...
    }
    //var myProp: T // 오류 → 프로퍼티는 초기화되거나 abstract 로 선언되어야 함
                    // 데이터 타입이 특정되지 못하므로 인스턴스를 생성할 수 없기 때문

    // 주 생성자나 부 생성자에 형식 파라미터를 지정해 사용할 수 있다
    //class MyClass<T>(val myProp: T) {}    // 주 생성자 이용
    val myProp: T
    constructor(myProp: T) {    // 부 생성자 이용
        this.myProp = myProp
    }
}

fun main() {
    var a = MyClass<Int>(12)
    // 객체 a 가 생성되면서 데이터 타입이 Int 형으로 결정되며
    // 생성자에 의해 12가 myProp 에 초기화 된다
    println(a.myProp)
    println(a.javaClass)
}