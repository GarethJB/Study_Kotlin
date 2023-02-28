package com.example.study.book.`object`


// ◆ 클래스 ◆

class BirdOne {   // ① 클래스의 정의
    // ② 프로퍼티(속성)
    var name: String = "mybird"
    var wing: Int = 2
    var beak: String = "short"
    var color: String = "blue"

    // ③ 메소드(함수)
    fun fly() = println("Fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}

fun main() {
    val coco = BirdOne()  // ④ 클래스의 생성자를 통한 객체의 생성
    coco.color = "blue"     // ⑤ 객체의 프로퍼티에 값 할당

    println("coco.color: ${coco.color}")    // ⑥ 객체의 멤버 프로퍼티 읽기
    coco.fly()
    coco.sing(3)
}

// ▶ 객체와 인스턴스 정리 ◀

/*
    BirdOne 은 모든 새를 가리키는 개념일 뿐 실제 살아서 움직이는 것이 아니다
    즉, BirdOne 클래스란 일종의 선언일 뿐 실제 메모리에 존재해 실행되고 있는 것이 아니다

    이 클래스로 부터 객체 Object 를 생성해야만 비로소 클래스라는 개념의 실체인 객체가
    물리적인 메모리 영역에서 실행된다다

    이것을 객체 지향 언어에서는 구체화 또는 인스턴스화 되었다고 한다
    그래서 메모리에 올라간 객체를 인스턴스 Instance 라고 한다


*/