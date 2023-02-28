package com.example.study.book.function


// ▶ 인라인 함수 ◀
//  인라인 함수는 이 함수가 호출되는 곳에
//  함수 본문의 내용을 모두 복사해 넣어
//  함수의 분기 없이 처리되기 때문에 코드의 성능을 높일 수 있다

//  인라인 함수는 람다식 파라미터를 갖고 있는 함수에서 동작한다
//  보통 함수는 호출되었을 때 다른 코드로 분기해야 하기 때문에
//  내부적으로 기존 내용을 저장했다가 다시 돌아올 때 복구하는 작업에
//  프로세스와 메모리를 꽤 사용해야하는 비용이 든다

/*
    - 일반적인 함수 호출
    fun sub(...) { abc }
    fun main() {
        sub() // → 분기
        sub() // → 분기
    } → 일반적인 함수 호출은 함수가 호출될 때마다 분기한다

    - 인라인 함수 호출
    inline fun sub(...) { abc }
    fun main() {
        sub() // → 본문 abc 로 복사됨
        sub() // → 본문 abc 로 복사됨
    } → 내용이 복사되어 main() 함수의 블록 코드에 들어간다
    #   즉, 일반 함수의 호출처럼 매번 분기하지 않아도 되어
        분기 없이 흐름에 방해하지 않고 코드가 수행된다
*/

fun main() {

    // 인라인 함수 shortFunc()의 내용이 복사되어 shortFunc 으로 들어감
    shortFunc(3) { println("First call: $it") }
    shortFunc(5) { println("Second call: $it") }
    //  코드상에서는 shortFunc() 함수가 2번 호출되는 것처럼 보이지만
    //  역컴파일해 보면 shortFunc() 함수의 내용이 복사된 것을 알 수 있다

    println()

    // noinline 키워드로 람다식의 인라인 막기
    shortFunc2(3) { println("First call: $it") }

    println()

    // return 으로 람다식 빠져나오기
    shortFunc3(3) {
        println("First call: $it")
        return
    }

    println()

    shortFunc4(3) {
        println("First call: $it")
        //return 사용 불가
    }

}

// 인라인 함수 작성
inline fun shortFunc(a: Int, out: (Int) -> Unit) {
    println("Before calling out()")
    out(a)
    println("After calling out()")
}


//  인라인 함수 제한
//  noinline 키워드 사용
inline fun shortFunc2(a: Int, noinline out: (Int) -> Unit) {
    println("Before calling out()")
    out(a)
    println("After calling out")
}


// 인라인 함수와 비지역 반환
// 인라인 함수에서 사용한 람다식에서는 return 을 사용할 수 있다
inline fun shortFunc3(a: Int, out: (Int) -> Unit) {
    println("Before calling out()")
    out(a)
    println("After calling out")
    // out(a)는 인라인 되어 있기 때문에 return 문까지 포함
    // 따라서 "After calling out" 은 실행되지 않음
}


// 비지역 반환을 금지
inline fun shortFunc4(a: Int, crossinline out: (Int) -> Unit) {
    println("Before calling out()")
    nestedFunc { out(a) }
    println("After calling out()")
}

fun nestedFunc(body: () -> Unit) {
    body()
}
//  crossinline 키워드는 비지역 반환을 금지해야 하는 람다식에 사용한다
//  crossinline 을 사용하면 람다식에서 return 문이 사용되었을 때
//  코드 작성 단계에서 오류를 보여줘 잘못된 비지역 반환을 방지할 수 있다


