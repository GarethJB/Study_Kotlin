package com.example.study.book.generic




// ◆ 제네릭 ◆

/*  제네릭은 클래스 내부에서 사용할 자료형을 나중에 인스턴스를 생성할 때 확정한다
    컴파일 시간에 데이터 타입을 검사해 적당한 자료형을 선택할 수 있도록 하기 위함
    객체 데이터 타입의 안전성을 높이고, 형 변환의 번거로움이 줄어든다                  */

/*  - 제네릭의 일반적인 사용 방법

    <> [앵글 브래킷] 사이에 형식 파라미터를 넣어 선언
    형식 파라미터는 하나 이상 지정할 수 있다
    T 와 같이 특정 영문의 대문자로 사용하며 나중에 필요한 데이터 타입으로 대체된다       */

class Box<T>(t: T) {    // 형식 파라미터로 받은 인자를 name 에 저장
    var name = t
}

fun main() {
    val box1: Box<Int> = Box<Int>(1)
    val box2: Box<String> = Box<String>("Hello")
    println(box1.name)
    println(box2.name)
}