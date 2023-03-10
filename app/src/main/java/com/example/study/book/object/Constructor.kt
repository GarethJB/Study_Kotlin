package com.example.study.book.`object`



/*  ◆ 생성자 ◆

    생성자란 클래스를 통해 객체가 만들어질 때 기본적으로 호출되는 함수를 말한다
    외부에서 인자를 받아 초기화할 수 있도록 특별한 함수인 constructor() 를 정의한다

    class 클래스 이름 constructor(필요한 파라미터...) { // 주 생성자의 위치
        ...
        constructor(필요한 파라미터...) {  // 부 생성자의 위치
            // 프로퍼티의 초기화
        }
        [constructor(필요한 파라미터...) {...}]    // 추가 부 생성자
    }

    생성자는 주 생성자 Primary Constructor 와 부 생성자 Secondary Constructor 로 나뉘며
    필요에 따라 주 생성자 또는 부 생성자를 사용할 수 있다
    부 생성자는 필요하면 파라미터를 다르게 여러 번 정의할 수 있다                             */

// ▶ 부 생성자 ◀

class BirdConstructor {
    // ① 프로퍼티 - 선언만 함
    var name: String
    var wing: Int
    var beak: String
    var color: String

    // ② 부 생성자 - 파라미터를 통해 초기화할 프로퍼티에 지정
    constructor(name: String, wing: Int, beak: String, _color: String) {
        this.name = name    // ③ this.name 은 선언된 현재 클래스의 프로퍼티를 나타냄
        this.wing = wing
        this.beak = beak
        color = _color      // _ (언더바) 를 파라미터에 사용하고 프로퍼티에 this를 생략할 수 있다
    }

    // 부 생성자를 여러 개 포함한 클래스 사용하기
    // 클래스 내부에 constructor() 함수 형태로 파라미터가 다르게 정의해야 한다
    constructor(_name: String, _beak: String) {
        name = _name
        wing = 2
        beak = _beak
        color = "grey"
    }


    // 메소드
    fun fly() = println("Fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}


// 주 생성자 선언
//class BirdPrimary constructor(_name: String, _wing: Int, _beak: String, _color: String) {
class BirdPrimary(var name: String, var wing: Int, var beak: String, var color: String) {   // constructor 키워드 생략 가능
    // 프로퍼티 → 프로퍼티는 파라미터 안에 var 를 사용해 프로퍼티로서 선언되어 본문에서 생략됨
    //var name: String = _name
    //var wing: Int = _wing
    //var beak: String = _beak
    //var color: String = _color

    // 메소드
    fun fly() = println("Fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}


// 초기화 블록을 가진 주 생성자
// init{ ... } 초기화 블록을 클래스 선언부에 넣어줘야 한다
class BirdInit(var name: String, var wing: Int, var beak: String, var color: String) {
    // ① 초기화 블록
    init{
        println("---------- 초기화 블록 시작 ----------")
        println("이름은 $name, 부리는 $beak")
        this.sing(3)
        println("---------- 초기화 블록 끝 ----------")
    }

    // 메소드
    fun fly() = println("Fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}


// 프로퍼티의 기본값 지정
// 생성자의 파라미터에 기본값을 사용 → 객체를 생성할 때 기본값이 있는 인자는 생략 가능
class BirdProperty(var name: String = "Noname", var wing: Int = 2, var beak: String, var color: String) {

}




fun main() {
    val coco = BirdConstructor("myBird", 2, "short", "blue")   // ④ 생성자의 인자로 객체 생성과 동시에 초기화

    coco.color = "Yellow"
    println("coco.color: ${coco.color}")
    coco.fly()
    coco.sing(3)

    println()

    // 첫 번째 부 생성자 호출
    val bird1 = BirdConstructor("myBird2", 2, "short", "blue")
    // 두 번째 부 생성자 호출
    val bird2 = BirdConstructor("myBird3", "long")
    println("bird1.color: ${bird1.color}")
    println("bird2.beak: ${bird2.beak}")


    println()

    // 주 생성자를 사용하는 Bird 클래스 선언
    val bird3 = BirdPrimary("myBird4", 2, "short", "blue")
    bird3.color = "Yellow"
    println("bird3.color: ${bird3.color}")
    bird3.fly()
    bird3.sing(3)

    println()

    // 초기화 블록이 있는 주 생성자
    // ② 객체 생성과 함께 초기화 블록 수행
    val bird4 = BirdInit("myBird5", 2, "short", "blue")

    bird4.color = "yellow"
    println("bird4.color: ${bird4.color}")
    bird4.fly()
    // 초기화 블록에서 명시한 내용은 객체 생성과 함께 같이 실행된다
    // 즉, 객체 생성 시점에서 코드 수행 문장을 실행할 수 있다

    println()

    // 프로퍼티 기본값이 지정된 생성자
    val bird5 = BirdProperty(beak = "long", color = "red")  // 기본값이 없는 것만 전달 가능

    println("bird5.name: ${bird5.name}, bird5.wing: ${bird5.wing}")
    println("bird5.color: ${bird5.color}, bird5.beak: ${bird5.beak}")
}

/*
    객체가 생성되어 프로퍼티를 초기화하면 부 생성자로 전달

                        ↓

    부 생성자의 파라미터 [name] 가 [this.name] 프로퍼티를 초기화한다

                        ↓

    메모리에 로드된 객체의 멤버 프로퍼티가 초기화 됨
 */









