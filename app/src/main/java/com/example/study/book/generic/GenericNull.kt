package com.example.study.book.generic



// ◆ 형식 매개변수의 null 제어 ◆

// 제네릭의 형식 매개변수는 기본적으로 null 이 가능한 형태로 선언된다
// 자료형을 선언할 경우 <Int?> 와 같이 자료형에 ? 기호를 사용해야 한다
// 형식 매개변수는 <T: Any> 와 같이 Any 로 제한하여 null 을 지정할 수 없게 할 수 있다

class GenericNull<T> {  // 기본적으로 null 이 허용되는 형식 매개변수
    fun EqualityFunc(arg1: T, arg2: T) {
        println(arg1?.equals(arg2))
    }
}

class GenericNoneNull<T: Any> { // 자료형 Any 가 지정되어 null 을 허용하지 않음
    fun EqualityFunc(arg1: T, arg2: T) {
        println(arg1?.equals(arg2))
    }
}

fun main() {
    val obj = GenericNull<String>() // non-null 로 선언됨
    obj.EqualityFunc("Hello", "World")  // null 이 허용되지 않음

    val obj2 = GenericNull<Int?>()  // null 이 가능한 형식으로 선언됨
    obj2.EqualityFunc(null, 10) // null 사용

    //val obj3 = GenericNoneNull<Int?>()    // 오류 → null 이 허용되지 않음
}

