package com.example.study.book


// ▶ 변수 초기화
val valTest: Int = 32   // 재할당 불가
var varTest: Int = 32   // 재할당 가능

/*  var → 키워드
    valTest, varTest → 변수명
    Int → 데이터 타입

    32 → 값
    # SideEffect 를 피하고 싶다면 var 보다 val 을 쓰는 것이 좋다
    # 타입추론 기능을 지원하지만, 명시적으로 타입을 선언해주는 것이 유지보수, 가독성 측면에서 좋다  */




// ▶ 코틀린 함수
fun functionTest(x: Int, y: Int): Int {
    return x + y
}
/*  fun → 함수키워드
    functionTest → 함수명
    (x: Int, y: Int) → 함수 파라미터
    : Int → 리턴타입
    return x + y → 함수 body

    # 함수의 리턴타입은 생략할 수 없다
    # 생략이 가능한 경우는 반환타입이 Unit 일 경우에만 가능
    # 리턴타입을 생략하면 default 로 리턴타입이 Unit 이 된다
    # 코틀린의 Unit 은 싱글톤 객체다
    # 함수의 바디가 한줄일 경우에는 {...} 대신에 = 로 쓸 수 있다
    # 클래스나 오브젝트 내부에 선언할 필요 없이 파일을 만들어 선언만 해두면 컴파일러가 알아서 추론  */




