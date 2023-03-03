package com.example.study.book.classandinterface




// ◆ 데이터 클래스 ◆

// DTO 를 의미하며 오직 데이터를 기술하는 용도로만 사용

/*  - DTO 를 사용하는 이유?
    데이터를 주고 받는 표준 방법을 정하면
    전송하거나 받고자 하는 어떤 요소든 데이터를 쉽게 다룰 수 있기 때문  */

// 데이터 클래스 선언
data class expDataClass(var name: String, var email: String)

/*  - 데이터 클래스의 조건
    주 생성자는 최소한 하나의 파라미터를 가져야 한다
    주 생성자의 모든 파라미터는 val, var 로 지정된 프로퍼티여야 한다
    데이터 클래스는 abstract, open, sealed, inner 키워드를 사용할 수 없다    */

// 부 생성자를 통해 인자를 더 초기화 할 수 있다
// init {} 을 넣어 데이터를 위한 간단한 로직을 포함 시킬 수 있다

/*  - 데이터 클래스가 자동으로 생성하는 메소드
    equals() : 두 객체의 내용이 같은지 비교하는 연산자
    hashCode() : 객체를 구별하기 위한 고유한 정수값 생성
                 데이터 세트나 해시 테이블을 사용하기 위한 하나의 생성된 인덱스
    copy() : 빌더 없이 특정 프로퍼티만 변경해서 객체에 복사
    toString() : 데이터 객체를 읽기 편한 문자열로 반환
    componentN() : 객체의 선언부 구조를 분해하기 위해 프로퍼티에 상응하는 메소드       */

data class CustomerDataClass(var name: String, var email: String) {
    var job: String = "UnKnown"
    constructor(name: String, email: String, _job: String): this(name, email) {
        job = _job
    }
    init {
        // 간단한 로직을 여기에 작성한다
    }
}


// 함수로부터 객체가 반환될 경우
fun myFunc(): CustomerDataClass {
    return CustomerDataClass("Mickey", "mic@abc.com")
}




fun main() {
    val cus1 = CustomerDataClass("Sean", "sean@mail.com")
    val cus2 = CustomerDataClass("Sean", "sean@mail.com")

    println(cus1 ==  cus2)  // 동등성 비교
    println(cus1.equals(cus2))  // 동등성 비교
    println("${cus1.hashCode()}, ${cus2.hashCode()}")

    val cus3 = cus1.copy(name = "Alice")    // name 만 변경하고자 할때
    println(cus1.toString())
    println(cus3.toString())

    println()

    // 객체 디스트럭처링
    // 객체가 가지고 있는 프로퍼티를 개별 변수로 분해하여 할당하는 것
    // 변수를 선언할 때 소괄호를 사용해서 분해하고자 하는 객체를 지정한다

    // cus1 객체의 프로퍼티 값 2개를 각각 name 과 email 로 선언된 변수에 가져온다
    val (name, email) = cus1
    println("name = $name, email = $email")

    // 특정 프로퍼티를 가져올 필요가 없는 경우 _ [언더스코어] 를 사용해 제외할 수 있다
    val (_, email2) = cus2
    println("email2 = $email2")

    // 개별적으로 프로퍼티를 가져오기 위해 componentN 메소드를 사용할 수 있다
    val name3 = cus3.component1()
    val email3 = cus3.component2()
    println("name = $name3, email = $email3")

    println()

    // 반복문 사용
    val customers = listOf(cus1, cus2, cus3)    // 모든 객체를 컬렉션 List 목록으로 구성
    for ((name, email) in customers) {  // 반복문을 사용해 모든 객체의 프로퍼티 분해
        println("name = $name, email = $email")
    }

    println()

    // 함수로부터 객체가 반환될 경우 사용
    val (myName, myEmail) = myFunc()

    println()

    // 람다식으로 디스트럭처링된 변수 출력
    val myLambda = {
        (nameLa, emailLa): CustomerDataClass ->
        println(nameLa)
        println(emailLa)
    }
    myLambda(cus1)



}