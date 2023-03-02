package com.example.study.book.conditionalstatement



// ◆ return 문 ◆

// 값을 반환할 때 사용된다
// return 이후의 코드는 실행되지 않는다


// ▶ return 으로 Unit 반환하기
// 특정 데이터타입을 반환하지 않을 경우 default 로 Unit 을 사용

// ① Unit 을 명시적으로 반환
fun hello1(name: String): Unit {
    println(name)
    return Unit
}

// ② Unit 이름을 생략한 반환
fun hello2(name: String): Unit {
    println(name)
    return
}

// ③ return 자체를 생략
fun hello3(name: String) {
    println(name)
}



// ▶ 람다식에서 return 사용
// inline 으로 선언된 함수에서 람다식을 파라미터로 사용하면 람다식에서 return 을 사용할 수 있다
// inline 으로 선언되지 않은 람다식에서는 return@label 과 같이 label 표기와 함께 사용해야 한다

// inline 을 사용한 람다식의 반환
inline fun inlineLambda(a: Int, b: Int, out: (Int, Int) -> Unit) {
    out(a, b)
}

fun retFunc1() {
    println("start of retFunc1")
    inlineLambda(13, 3) { a, b ->
        val result =  a + b
        if(result > 10) return  // 10보다 크면 이 함수를 빠져나감
        println("result: $result")  // 10보다 크면 이 문장에 도달하지 못함
    }
    println("end of retFunc1")
}



// 라벨을 사용한 람다식의 반환
// [람다식 함수 이름] [라벨 이름]@ { ... return@[라벨 이름] }
fun noInlineLambda(a: Int, b: Int, out: (Int, Int) -> Unit) {   // inline 을 제거
    out(a, b)
}

fun retFunc2() {
    println("start of retFunc2")
    noInlineLambda(13, 3) lit@{ a, b -> // ① 람다식 블록의 시작 부분에 라벨을 지정
        val result = a + b
        if (result > 10) return@lit // ② 라벨을 사용한 블록의 끝부분으로 반환
        println("result: $result")
    }   // ③ 이 부분으로 빠져나감
    println("end of retFunc2")  // ④ 이 부분이 실행
}



// 암묵적 라벨
// 람다식의 명칭을 그대로 라벨처럼 사용
fun retFunc3() {
    println("start of retFunc3")
    noInlineLambda(13, 3) { a, b ->
        val result = a + b
        if (result > 10) return@noInlineLambda // 람다식의 명칭을 그대로 라벨처럼 사용 (암묵적 라벨)
        println("result: $result")
    }
    println("end of retFunc3")
}



// 익명 함수를 사용한 반환
// 람다식 대신에 익명 함수를 사용한 경우
// 라벨을 사용하지 않고도 가까운 익명 함수 자체가 반환
// 명시적으로 반환해야 할 것이 여러 개라면 익명 함수를 쓰는게 좋다
fun retFunc4() {
    println("start of retFunc4")
    inlineLambda(13, 3, fun (a, b) {    // 익명 함수를 파라미터로 사용
        val result = a + b
        if (result > 10) return // 라벨 없이 return 문 사용
        println("result: $result")
    })
    println("end of retFunc4")
}

fun main() {

    // inline 으로 선언된 람다식 반환
    retFunc1()

    println()

    // 라벨을 사용한 람다식의 반환
    retFunc2()

    println()

    // 암묵적 라벨을 사용한 람다식의 반환
    retFunc3()

    println()

    // 익명 함수를 사용한 반환
    retFunc4()
}






