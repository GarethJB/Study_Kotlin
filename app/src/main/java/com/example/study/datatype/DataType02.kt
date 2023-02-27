package com.example.study.variable

fun main() {

    // ◆ 자료형 검사하고 변환하기 ◆

    // 코틀린에서 null 상태인 변수를 허용하려면 ? 기호를 사용해 선언해야 한다
    // null 허용 변수를 사용하려면 null 을 검사하고 처리하는 방법까지 고려해야 한다


    // ▶ null 을 허용한 변수 검사하기 ◀
    // 코틀린은 변수에 아예 null 을 허용하지 않아 NPE(NullPointerException) 을 예방
    // 자료형 뒤에 ?(물음표) 기호를 명시하여 null 을 할당
    var str1: String? = "Hello Kotlin"
    str1 = null
    println("str1 : $str1")

    // ※ String 과 String? 는 서로 다른 자료형


    // ▶ 세이프 콜과 non-null 단정 기호를 활용하여 null 허용 변수 사용하기 ◀
    var str2: String? = "Hello Kotlin"
    str2 = null
    println("str2 : $str2")
    //println("str2 length : ${str2.length}")    // 오류 → null 을 허용하면 length 가 실행될 수 없음
    println("str2 length : ${str2?.length}")     // str2 을 세이프 콜로 안전하게 호출
    //println("str2 length : ${str2!!.length}")  // 오류 → 단정 기호(!!) 를 사용하여 프로그램 실행 시 NPE 를 강제로 발생



    // ▶ 조건문을 활용해 null을 허용한 변수 검사 ◀
    var str3: String? = "Hello Kotlin"
    str3 = null
    val len = if(str3 != null) str3.length else -1  // 조건식을 통해 null 상태 검사
    println("str3 : $str3")
    println("str3 length : ${len}")



    // ▶ 세이프 콜과 엘비스 연산자를 활용해 null 허용 변수 더 안전하게 사용 ◀
    // 엘비스 연산자 ?: 는 null 이 아닐 경우 왼쪽 식을, null 일 경우 오른쪽 식을 실행한다
    var str4: String?= "Hello Kotlin"
    str4 = null
    println("str4 : $str4")
    println("str4 length : ${str4?.length ?: -1}")  // 세이프 콜과 엘비스 연산자 사용
    str4 = "Hi!"
    println("str4 : $str4")
    println("str4 length : ${str4?.length ?: -1}")



    // ▶ 자료형과 비교하고 검사하고 변환 ◀

    // 자료형 변환
    val a: Int = 1
    //val b: Double = a     // 자료형 불일치 오류 발생
    val b: Double = a.toDouble()    // 변환 메소드 사용
    //val c: Int = 1.1      // 자료형 불일치 오류 발생


    // 자료형이 다른 값의 연산 : 범위가 큰 자료형으로 자동 형 변환하여 연산
    val result = 1L + 3
    println("result : $result") // Long + Int → result 의 자료형은 Long



    // ▶ 기본형과 참조형 자료형의 비교 원리 ◀

    // ※ == : 단순히 값만 비교 → 값이 동일하면 true, 다르면 false 반환
    // ※ === : 참조 주소를 비교 → 값과 상관없이 참조가 동일하면 true, 값이 동일하더라도 참조 주소가 다르면 false 반환

    var exp1: Int = 128
    var exp2: Int = 128
    println("exp1 == exp2 : ${exp1 == exp2}")   // true
    println("exp1 === exp2 : ${exp1 === exp2}") // true

    val exp3: Int = 128
    val exp4: Int? = 128
    println("exp3 == exp4 : ${exp3 == exp4}")
    println("exp3 === exp4 : ${exp3 === exp4}")


    // ▶ 이중 등호 비교와 삼중 등호 비교 ◀
    val exp5: Int = 128
    val exp6 = exp5
    println("exp5 === exp6 : ${exp5 === exp6}") // true → 자료형이 기본형인 Int 형이 되어 값이 동일

    val exp7: Int? = exp5
    val exp8: Int? = exp5
    val exp9: Int? = exp7
    println("exp7 == exp8 : ${exp7 == exp8}")   // true → 값의 내용만 비교할 경우 동일
    println("exp7 === exp8 : ${exp7 === exp8}") // false → 값의 내용은 같지만 참조 주소를 비교해 다른 객체임
    println("exp7 === exp9 : ${exp7 === exp9}") // true → 값의 내용도 같고 참조된 객체도 동일

    // ※ 저장되는 값이 -128 ~ 127 범위에 있으면 값이 캐시에 저장되어 참조된다 → 성능 향상
    // 캐시에 저장되면 참조 주소가 같아지므로 삼중 등호로 비교한 값은 모두 true 가 된다



    // ▶ 자료형 검사 ◀
    // is 키워드를 사용하여 왼쪽 항의 변수가 오른쪽 항의 자료형과 같으면 true, 다르면 false
    val exp10 = 256

    if(exp10 is Int) {
        println(exp10)
    }else if(exp10 !is Int) {
        println("Not a Int")
    }



    // ▶ Any 자료형 ◀
    // Any 자료형은 코틀린의 최상위 기본 클래스로 어떤 자료형이라도 될 수 있다
    // Any 형을 사용했을 때 is 키워드를 사용하여 자료형을 검사하면 검사한 자료형으로 스마트 캐스트 된다
    val exp11: Any
    exp11 = "Hello"
    if(exp11 is String) {
        println(exp11.length)   // exp11 은 String 으로 스마트 캐스트
    }



    // ▶ as에 의한 스마트 캐스트 ◀
    // as 는 형변환이 가능하지 않으면 예외를 발생
    val exp13 = null
    //val exp12: String = exp13 as String // exp13 이 null 일 경우 형 변환을 할 수 없음
    val exp12: String? = exp13 as? String   // null 가능성까지 고려하여 작성
    println("exp12 : $exp12")



    // ▶ 묵시적 변환 ◀
    // 코틀린의 모든 클래스는 Any 형의 자식 클래스로 Any 형이라는 슈퍼클래스를 가진다
    // Any 형은 언제든 필요한 자료형으로 자동 변환할 수 있다 → 이것을 묵시적 변환 이라고 한다
    var exp14: Any = 1  // Any 형 exp14 는 1로 초기화될 때 Int 형이 됨
    println("exp14 : $exp14")
    println("exp14 Type : ${exp14.javaClass}")

    exp14 = 20L // Int 형이였던 exp14 는 변경된 값 20L 에 의해 Long 형이 됨
    println("exp14 : $exp14")
    println("exp14 Type : ${exp14.javaClass}")


    // Any 형으로 인자를 받는 함수 만들기
    checkArg("Hello")   // 문자열을 인자로 넣음
    checkArg(5)         // 숫자를 인자로 넣음


}

// Any 형으로 인자를 받는 함수
fun checkArg(x: Any) {
    if (x is String) {
        println("x is String : $x")
    }else if (x is Int) {
        println("x is Int : $x")
    }
}