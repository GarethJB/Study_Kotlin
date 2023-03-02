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

}

fun main() {

    // 코틀린에서 Getter 와 Setter 가 작동하는 방식
    // 객체 user 를 생성하고 점(.) 표기법으로 프로퍼티에 접근한다
    // user.name 은 프로퍼티에 직접 접근하는 것이 아니라
    // 코틀린 내부의 Getter & Setter 메소드를 통해 접근하는 것
    val user1 = User1(1, "Sean", 30)

    val name = user1.name    // Getter 에 의한 값 획득

    user1.age = 41   // Setter 에 의한 값 지정

    println("name: $name, ${user1.age}")


    // 기본 Getter 와 Setter 지정하기
    val user2 = User2(1, "홍길동")

}