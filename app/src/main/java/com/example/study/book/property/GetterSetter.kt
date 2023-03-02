package com.example.study.book.property



// ◆ 코틀린에서의 Getter & Setter ◆

// 코틀린에서는 각 프로퍼티에 게터와 세터가 자동으로 만들어진다


// 주 생성자에 3개의 파라미터 정의
class User1(_id: Int, _name: String, _age: Int) {
    // 프로퍼티
    val id: Int = _id   // 불변(읽기 전용)
    var name: String = _name    // 변경 가능
    var age: Int = _age // 변경 가능
} // User 클래스를 간소화 → class User2(val id: Int, var name: String, var age: Int)


// 기본 Getter 와 Setter 직접 지정하기
/*  게터와 세터가 포함되는 프로퍼티 선언
    var [프로퍼티 명]: [프로퍼티 데이터타입] = [프로퍼티 초기화]
        get() { 게터 본문 }
        set(value) { 세터 본문 }
    val [프로퍼티 명]: [프로퍼티 데이터타입] = [프로퍼티 초기화]
        get() { 게터 본문 }
 */
class User2(_id: Int, _name: String, _age: Int) {
    // 프로퍼티
    val id: Int = _id
    get() = field

    var name: String = _name
    get() = field
    set(value) {
        field = value
    }

    var age: Int = _age
    get() = field
    set(value) {
        field = value
    }
    // value : Setter 의 파라미터로 외부로부터 값은 가져옴
    // field : 프로퍼티를 참조하는 변수 → 보조 필드
}

/*  보조 필드의 역할
    field 는 프로퍼티를 참조하는 변수로 보조 필드 Backing Field 라고도 한다
    get() = field 는 결국 각 프로퍼티의 값을 읽는 특별한 식별자다
    임시적인 보조 필드를 따로 사용해 프로퍼티 변수에 접근하는 것
    set() 에도 값을 할당하기 위해 프로퍼티 이름을 직접 사용하지 않도록 주의     */


// 커스텀 Getter 와 Setter
// 입력 문자를 대문자로 바꾸는 등의 특정 연산을 수행해야할 때 사용
class User3(_id: Int, _name: String, _age: Int) {
    val id: Int = _id
    var name: String = _name
        set(value) {
            println("The name was changed")
            field = value.toUpperCase() // ① 받은 인자를 대문자로 변경해 프로퍼티에 할당
        }
    var age: Int = _age
}



// 임시적인 보조 프로퍼티의 사용
// 보조 필드를 사용하지 않는 경우에는
// 임시적으로 사용할 프로퍼티를 선언해 놓고 Getter 나 Setter 에서 사용할 수 있다
class User4(_id: Int, _name: String, _age: Int) {
    val id: Int = _id
    private var tempName: String? = null    // name 이 null 이 되는 경우를 처리하기 위한 보조 프로퍼티
    var name: String = _name
        get() {
            if (tempName == null) tempName = "NONAME"
            return tempName ?: throw java.lang.AssertionError("Asserted by others")
        }
    var age: Int = _age
}



// 프로퍼티의 오버라이딩
// open 키워드를 사용해 프로퍼티를 선언해야 한다
open class First {
    open val x: Int = 0 // ① 오버라이딩 가능
        get() {
            println("First x")
            return field
        }
    val y: Int = 0  // ② open 키워드가 없으면 final 프로퍼티
}

class Second : First() {
    override val x: Int = 0 // ③ 상위 클래스와 구현부가 다르게 오버라이딩됨
        get() {
            println("Second x")
            return field + 3
        }
    // override val y: Int = 0  // ④ 오류 → 오버라이딩 불가
}



fun main() {

    // 코틀린에서 Getter 와 Setter 가 작동하는 방식
    // 객체 user 를 생성하고 점(.) 표기법으로 프로퍼티에 접근한다
    // user.name 은 프로퍼티에 직접 접근하는 것이 아니라
    // 코틀린 내부의 Getter & Setter 메소드를 통해 접근하는 것
    val user1 = User1(1, "Sean", 30)

    val name = user1.name    // Getter 에 의한 값 획득

    user1.age = 41   // Setter 에 의한 값 지정

    println("user1.name: $name, ${user1.age}")

    println()

    // 기본 Getter 와 Setter 지정하기
    val user2 = User2(1, "홍길동", 30)
    // user2.id = 2 // val 프로퍼티는 값 변경불가
    user2.age = 35  // Setter
    println("user2.age = ${user2.age}") // Getter

    println()

    // 커스텀 Getter Setter
    val user3 = User3(1, "심청", 35)
    user3.name = "coco" // ② 여기서 사용자 고유의 출력 코드가 실행
    println("user3.name = ${user3.name}")

    println()

    // 임시적인 보조 프로퍼티 사용
    val user4 = User4(1, "박문수", 35)
    user4.name = ""
    println("user4.name = ${user4.name}")

    println()

    // 프로퍼티의 오버라이딩
    val second = Second()
    println(second.x)   // ⑤ 오버라이딩된 두 번째 클래스 객체의 x
    println(second.y)   // 상위 클래스로부터 상속받은 값

}