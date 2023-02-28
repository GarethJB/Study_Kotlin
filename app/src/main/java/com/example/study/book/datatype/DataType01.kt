package com.example.study.variable

fun main() {

    // ◆ 자료형 ◆

/*
    ▶ 코틀린의 자료형은 참조형 자료형을 사용 ◀
     - 자바에서는 Primitive Data Type 과 Reference Data Type 모두 사용하지만
     - 코틀린에서는 Reference Data Type 만 사용
     - 참조형으로 선언한 변수는 성능 최적화를 위해 코틀린 컴파일러에서 다시 기본형으로 대체

     ※ 기본형 자료형 (Primitive Data Type) : 가공되지 않은 순수한 자료형
     ※ 참조형 자료형 (Reference Data Type) : 객체를 생성하고 동적 메모리 영역에 데이터를 둔 다음 이것을 참조하는 자료형

     ※ 기본형으로 선언한 변수는 스택 영역에 저장되며 값이 저장된 메모리의 크기도 고정
     ※ 참조형으로 선언한 변수는 스택 영역에 참조주소가 저장되고 실제 객체는 힙 영역에 저장
*/

    // ▶ 정수 자료형 ◀

    // 코틀린의 정수 자료형은 부호가 있는 것과 부호가 없는 것으로 나눌 수 있다
    val num01 = 127 // Int 형으로 추론
    val num02 = -32769  //Int 형으로 추론
    val num03 = 214423412   // Int 형으로 추론
    val num04 = 9223372036854775807 // Long 형으로 추론


    // 접미사나 접두사를 사용하면 2진수나 16진수를 표현할 수 있다
    val exp01 = 123 // Int 형으로 추론
    val exp02 = 123L    // 접미사 L을 사용해 Long 형으로 추론
    val exp03 = 0x0F    // 접두사 0x를 사용해 16진 표기가 사용된 Int 형으로 추론
    val exp04 = 0b00001011 // 접두사 0b를 사용해 2진 표기가 사용된 Int 형으로 추론


    // Int 보다 작은 범위의 정수 자료형인 Byte, Short 형을 사용하려면 직접 자료형을 명시
    val exp05: Byte = 127   // 명시적으로 자료형을 Byte 형으로 지정
    val exp06 = 32767   // 명시적으로 자료형으류 지정하지 않으면 Short 형 범위의 값도 Int 형으로 추론
    val exp07: Short = 32767    // 명시적으로 자료형을 Short 형으로 지정


    // 음의 부호를 사용하지 않는 정수 자료형 (양수만 표현, 2배 더 많은 양수를 표현할 수 있다)
    // 부호가 없는 정수 자료형을 사용할 때는 값에 식별자를 사용, 자료형을 명시하지 않으면 값을 할당할 수 없음
    val uint: UInt = 153u
    val ushort: UShort = 65535u
    val ulong: ULong = 46322342uL
    val ubyte: UByte = 255u


    // 언더스코어 [ _ ] 로 자릿값을 구분할 수 있다 (값에 영향을 주지 않음)
    val exp08 = 1_000_000



    // ▶ 실수 자료형 ◀

    // 실수형은 자료형을 명시하지 않으면 Double 형으로 추론한다
    // Float 형으로 지정하고 싶다면 식별자 F를 실수 옆에 붙이면 된다
    val exp09 = 3.14    // Double 형으로 추론(Default)
    val exp10 = 3.14F   // 식별자 F에 의해 Float 형으로 추론

    // 부동 소수점 방식은 실수를 가수와 지수로 나누어 표현하는 방식
    // 비트의 제한 때문에 약간의 오차가 있으므로 사용할 때 주의해야함
    val exp11 = 3.14E-2 // 왼쪽으로 소수점 2칸 이동 → 0.0314
    val exp12 = 3.14e2  // 오른쪽으로 소수점 2칸 이동 → 314



    // ▶ 논리 자료형 ◀

    // Boolean 자료형
    // 크기 : 1비트
    // 값의 범위 : true, false
    // 조건을 검사할 때 주로 사용

    val isOpen = true   // isOpen 은 Boolean 형으로 추론
    val IsUploaded: Boolean // 변수를 선언만 한 경우 자료형(Boolean)을 반드시 명시



    // ▶ 문자 자료형 ◀

    // Char 자료형
    // 크기 : 2바이트(16비트)
    // 값을 저장할 때 문자 세트(아스키코드 표, 유니코드 표)를 참고하여 번호를 저장 → (ex) 'A' 를 65로 저장

    val ch = 'c'    // ch 는 Char 로 추론
    val ch2: Char   // 변수를 선언만 한 경우 자료형(Char)을 반드시 명시
    val ch3 = 'A'   // 문자 값을 선언한 후 자료형에 숫자를 더하는 방식으로 다른 문자를 표현할 수 있다
    ch3 + 1 // ch3 + 1 == B



    //  ▶ 문자열 자료형 ◀

    // String 자료형
    // 배열 형태로 되어 있음

    var str1: String = "Hello"
    var str2 = "World"
    var str3 = "Hello"

    // 힙 영역에 저장된 String Pool 이라는 공간에 문자열인 "Hello" 를 저장해 두고
    // 이 값을 str1, str3 이 참조하도록 함 → str1 과 str3 의 참조 주소는 동일
    println("str1 === str2 : ${str1 === str2}") // 결과 : false
    println("str1 === str3 : ${str1 === str3}") // 결과 : true

    // ※ == 연산자 : 값 비교
    // ※ === 연산자 : 값 + 참조 주소 비교

    // $ 기호를 사용하여 변수를 포함하여 출력
    var a = 1
    var s1 = "a is $a"  // String 자료형의 s1을 선언하고 초기화. 변수 a가 사용됨

    println("a : $a")
    println("s1 : $s1")


    // $ 기호를 사용하여 표현식을 포함하여 출력
    val str4 = "a = $a"
    val str5 = "a = ${a + 2}"   // 문자열에 표현식 사용


    println("str4 : $str4")
    println("str5 : $str5")

    // 이스케이프 문자 [\]
    val special = "\"hello\", I have \$15"
    println(special)

    val special2 = "${'"'}${'$'}9.99${'"'}"
    println(special2)



    // ▶ 형식화된 다중 문자열 사용하기 ◀
    val exp13 = 10
    val formattedString = """
        var a = 6
        var b = "Kotlin"
        println(a + $exp13)
        """
    println(formattedString)

}