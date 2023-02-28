package com.example.study.book.function

// ◆ 매개변수 활용 ◆

// ▶ 가변형일 땐 MutableMap 을 사용
fun add(name: String = "d", email: String = "default"): MutableMap<String, String> {
    var map = mutableMapOf<String, String>()
    map.put("name", name)
    map.put("email", email)
    // name 과 email 을 회원 목록에 저장
    // email 의 기본값은 "default" → email 로 넘어오는 값이 없으면 자동으로 "default" 입력

    return map
}


// ▶ 매개변수 이름과 함께 함수 호출 ◀
fun namedParam(x: Int = 100, y: Int =  200, z: Int) {
    println(x + y + z)
}


// ▶ 매개변수의 개수가 고정되지 않은 함수 사용 ◀
// vararg 라는 키워드를 사용해 다양한 인자의 개수를 전달받는 함수를 정의할 수 있다
fun normalVarargs(vararg counts: Int) {
    for (num in counts) {
        print("$num")
    }
    print("\n")
}

fun main() {

    // account 객체에 name 할당, email 은 할당하지 않음
    var account = add("홍길동")

    println("name : ${account["name"]}")    // 홍길동 출력
    println("email : ${account["email"]}")  // default 출력


    // 매개변수 이름과 함께 namedParam() 함수 호출
    namedParam(x = 200, z = 100)    // x,z 의 이름과 함께 함수 호출 (y는 기본값 사용)
    namedParam(z = 150)             // z의 이름과 함께 함수 호출 (x와 y는 기본값으로 지정)

    // vararg 를 사용한 함수 호출
    normalVarargs(1, 2, 3, 4)   // 4개의 인자 구성
    normalVarargs(4, 5, 6)      // 3개의 인자 구성

}