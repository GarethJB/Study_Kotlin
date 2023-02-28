package com.example.study.book.`object`

/*
    ◆ 인터페이스 ◆

    - 대략적인 설계 명세를 구현하고 인터페이스를 상속하는 하위 클래스에서 이를 구체화
    - 인터페이스에서는 프로퍼티의 상태 정보를 저장할 수 없다
    - abstract 로 정의된 추상 메소드나 일반 메소드가 포함된다
    - 메소드에 구현 내용이 포함될 수 있다
    - '기본 설계도' 개념


    ▶ 인터페이스를 사용하는 이유

    ※ 추상클래스의 단점
      - 추상 클래스는 클래스이기 때문에 2개 이상의 클래스로부터 프로퍼티나 메소드를 상속 받을 수 없음
      - 상위 클래스와 하위 클래스에 강한 연관이 생김 → 상위 클래스가 불완전하면 하위 클래스도 영향을 받음

    ※ 이와 상반되는 인터페이스 장점
      - 인터페이스는 클래스가 아니다 → 상속이라는 형태로 하위 클래스에 프로퍼티와 메소드를 전하지 않음
      - 인터페이스와 구현 클래스와 강한 연관을 갖지 않는다
      - 인터페이스는 원하는 만큼 구현 클래스에 붙여서 필요한 메소드를 구현해 내면 된다
      - 인터페이스가 바껴도 구현 클래스에 크게 영향을 끼치지 않음


    ▶ 인터페이스의 선언과 구현

    interface 인터페이스 이름 [: 인터페이스 이름...] {
        추상 프로퍼티 선언
        추상 메소드 선언

        [일반 메소드 선언 { ... }]
    }

    - 인터페이스의 본문에서 메소드는 추상 혹은 일반 메소드 모두 선언이 가능하지만
      프로퍼티는 오직 추상 메소드로만 선언해야 한다

 */

// Pet 인터페이스 선언
interface Pet {
    var category: String    // abstract 키워드가 없어도 기본은 추상 메소드
    val msgTags: String     // val 선언 시 게터의 구현이 가능
        get() = "I'm your lovely pet!"  // msgTags 는 게터를 통해 반환값을 지정 but 값을 저장할 순 없음

    // Pet 인터페이스에 species 프로퍼티 추가
    var species: String // 종을 위한 프로퍼티

    fun feeding()           // 마찬가지로 추상 메소드
    fun patting() {         // 일반 메소드 : 구현부를 포함하면 일반적인 메소드로 기본이 됨
        println("Keep patting!")    // 구현부
    }
}

open class Animal(val name: String)



// 구현 클래스 정의
class Cat(name: String, override var category: String) : Pet, Animal(name) {
    override var species: String = "cat"
    override fun feeding() {
        println("Feed the cat a tuna can!")
    }
}

// ① feeding 의 구현을 위해 인터페이스 Pet 지정
class Dog(name: String, override var category: String) : Animal(name), Pet {
    override var species: String = "dog"
    override fun feeding() {
        println("Feed the dog a bone")
    }
}


// 여러 인터페이스를 이용한 다중 상속
interface Bird {
    val wings: Int  // 추상 프로퍼티
    fun fly()       // 추상 메소드
    fun jump() {    // 일반 메소드
        println("bird jump!")
    }
}

interface Horse {
    val maxSpeed: Int
    fun run()
    fun jump(){
        println("jump!, max speed: $maxSpeed")
    }
}

class Pegasus: Bird, Horse {
    override val wings: Int = 2
    override val maxSpeed: Int = 100
    override fun fly() {
        println("Fly!")
    }
    override fun run() {
        println("Run!")
    }

    override fun jump() {
        super<Horse>.jump()
        println("Pegasus Jump!")
    }

}

// 애완동물 관리인 클래스 정의
class Master {
//    fun playWithPet(dog: Dog) {     // ② 각 애완동물 종류에 따라 오버로딩됨
//        println("Enjoy with my dog.")
//    }
//    fun playWithPet(cat: Cat) {     // ③ 고양이를 위한 메소드
//        println("Enjoy with my cat.")
//    }

    fun playWithPet(pet: Pet) {     // 인터페이스를 객체로 파라미터를 지정
        println("Enjoy with my ${pet.species}")
    }

}

fun main() {

    val obj = Cat("Coco", "small")
    println("Pet Category: ${obj.category}")
    println("Pet Message Tags: ${obj.msgTags}")
    obj.feeding()   // 구현된 메소드
    obj.patting()   // 기본 메소드

    println()

    val master = Master()
    val dog = Dog("Toto", "Small")
    val cat = Cat("Coco", "BigFat")
    master.playWithPet(dog)
    master.playWithPet(cat)

    println()

    val pegasus = Pegasus()
    pegasus.fly()
    pegasus.run()
    pegasus.jump()
}

// Cat 클래스는 Pet 인터페이스를 구현한 클래스가 된다
// 추상 프로퍼티나 추상 메소드였던 부분을 override 키워드를 사용해 구현해 준다
// 인터페이스의 구현은 클래스에서 상속을 나타내는 콜론(:)을 동일하게 사용해 정의

// Bird 와 Horse 라는 2개의 인터페이스로부터 Pegasus 클래스를 정의했고
// 두 인터페이스 Bird, Horse 가 가지는 모든 추상 프로퍼티와 추상 메소드를 오버라이딩하여 구현해준다
// 이미 구현되어 있는 jump() 는 필요에 따라서만 오버라이딩 할 수 있다
// 인터페이스의 기본 동작을 실행하려 할 때, 만일 이름이 동일한 경우 super<인터페이스명>.메소드명()
// 여기서는 Pegasus 클래스의 jump() 메소드에서 상위의 인터페이스를 호출하기 위해 super<Horse>.jump 를 사용용


