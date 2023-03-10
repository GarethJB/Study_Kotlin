package com.example.study.book.function



// ◆ 함수와 변수의 범위 ◆


// ▶ 함수의 범위 ◀

// 최상위 함수와 지역 함수
// 파일을 만들고 곧바로 main() 함수나 사용자 함수를 만든 경우 이것을 최상위 함수라 한다
// 함수 안에 또 다른 함수가 선언되어 있는 경우 지역 함수라 한다


// 최상위 및 지역 함수의 사용 범위
// 최상위 함수는 main() 함수의 앞이나 뒤에 선언해도 main() 함수 안에서 사용하는데 제약이 없다
// 지역 함수는 최상위 함수와 다르게 선언 순서에 영향을 받는다

// a() 함수에 b() 함수의 내용을 선언
fun a() = b()   // 최상위 함수이므로 b() 함수 선언 위치에 상관없이 사용 가능
fun b() = println("b")  // b() 함수의 선언

fun c()  {
    //fun d() = e() // 오류 → d()는 지역 함수이며 e()의 이름을 모름
    fun e() = println("e")
}

fun main() {
    a() // 최상위 함수는 어디서든 호출될 수 있다
    //e() // 오류 → c() 함수에 정의된 e() 는 c() 의 블록을 벗어난 곳에서 사용할 수 없다
}