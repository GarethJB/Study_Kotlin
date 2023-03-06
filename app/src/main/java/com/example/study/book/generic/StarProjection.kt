package com.example.study.book.generic




// ◆ 스타 프로젝션 ◆

// 어떤 자료형이라도 들어올 수 있으나 구체적으로 자료형이 결정되고 난 후에는
// 그 자료형과 하위 자료형의 요소만 담을 수 있도록 제한한다
// <*> 형태로 사용

// in 으로 정의되어 있는 타입 매개변수를 * 로 받으면 in Nothing 으로 간주하고
// out 으로 정의되어 있는 타입 매개변수를 * 로 받으면 out Any? 인 것으로 간주한다
// 따라서 * 을 사용할 때 그 위치에 따라 메소드 호출이 제한될 수 있다

class InOutTest<in T, out U>(t: T, u: U) {
    //val propT: T = t  // 오류 → T 는 in 위치이기 때문에, out 위치에 사용 불가
    val propU: U = u    // U 는 out 위치로 가능

    //fun func1(u: U)   // 오류 → U 는 out 위치이기 때문에 in 위치에 사용 불가
    fun func2(t: T) {   // T 는 in 위치에 사용됨
        print(t)
    }
}

fun starTestFunc(v: InOutTest<*, *>) {
    //v.func1(1)    // 오류 → Nothing 으로 인자를 처리함
    print(v.propU)
}