package com.example.study.book.generic



// ◆ 자료형 제한하기 ◆

// 제네릭 클래스나 메소드가 받는 형식 매개변수를 특정한 자료형으로 제한할 수 있다
// 형식 매개변수 다음에 : [콜론] 과 자료형을 기입하면 형식 매개변수 T의 자료형이 제한


// ▶ 클래스에서 형식 매개변수의 자료형 제한하기
// 자료형을 Int, Double, Long 등의 숫자형으로 제한
class Calc<T: Number> { // 클래스의 형식매개변수 제한 → Number 형
    fun plus(arg1: T, arg2: T): Double {
        return arg1.toDouble() + arg2.toDouble()
    }
}



// ▶ 함수에서 형식 매개변수의 자료형 제한하기
// 클래스와 동일하게 형식 매개변수 옆에 : 을 사용
fun <T: Number> addLimit(a: T, b: T, op: (T, T) -> T): T {
    return op(a, b)
}



// ▶ 다수 조건의 형식 매개변수 제한하기
// 2개의 인터페이스 구현이 포함된 클래스로 형식 매개변수 제한
interface InterfaceA
interface InterfaceB

class HandlerA: InterfaceA, InterfaceB
class HandlerB: InterfaceA

class ClassA<T> where T:InterfaceA, T:InterfaceB    // → 2개의 인터페이스를 구현하는 클래스로 제한


// 함수에서 where 사용
// myMax 의 인자 a, b를 Number [숫자형] 과 Comparable [비교형] 으로 한정
fun <T> myMax(a: T, b: T): T where T:Number, T:Comparable<T> {
    return if (a > b) a else b
}


fun main() {

    // Number 로 형식 매개변수 제한
    val calc = Calc<Int>()
    println(calc.plus(10, 20))

    val calc2 = Calc<Double>()
    println(calc2.plus(2.5, 3.5))

    val calc3 = Calc<Long>()
    println(calc3.plus(5L, 10L))

    //val calc4 = Calc<String>() // 오류 → 자료형의 제한으로 String 형이 될 수 없음


    // 다수 조건의 형식 매개변수 제한
    val obj1 = ClassA<HandlerA>()    // 제한조건을 만족하므로 객체 생성 가능
    //val obj2 = ClassB<HandlerB>() // → 제한범위를 만족하지 않으므로 객체 생성 불가능
}

