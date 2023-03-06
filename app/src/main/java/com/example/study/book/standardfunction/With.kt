package com.example.study.book.standardfunction




// ◆ with() 함수 활용 ◆

// with() 함수는 인자로 받는 객체를 이어지는 block 의 receiver 로 전달하며 결과값을 반환

// run() 함수와 거의 동일하지만
// with() 함수에서는 receiver 로 전달할 객체를 처리하므로 객체의 위치가 달라진다
public inline fun <T, R> with(receiver: T, block: T.() -> R): R = receiver.block()

// with() 함수는 매개변수가 2개이므로 with() { ... } 와 같은 형태로 넣어 줍니다
fun main() {
    data class User(val name: String, var skills: String, var email: String? = null)
    val user = User("홍길동", "default")

    val result = with (user) {
        skills = "Kotlin"
        email = "kildong@example.com"
    }
    println(user)
    println("result: $result")
}