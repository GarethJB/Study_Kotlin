package com.example.study.book.generic



// ◆ 상·하위 형식의 가변성 ◆

/*  - 가변성이란?

    형식 매개변수가 클래스 계층에 영향을 주는 것
    ex) 형식 A의 값이 필요한 모든 클래스에 형식 B의 값을 넣어도 문제가 없다면
    → B는 A의 Subtype [하위 형식] 이 된다                                        */

// 변성 개념은 List<String> 와 List<Any> 와 같이 기저 타입이 같고 인자가 다른
// 여러 타입이 서로 어떤 관계가 있는지 설명하는 개념이다
// 변성을 잘 호라용하면 사용에 불편하지 않으면서 타입 안전성을 보장하는 API 를 만들 수 있다


// 무변성 : T' 가 T 의 하위 자료형이면 → C<T> 와 C<T'> 는 아무 관계가 없다 [생산자 + 소비자]
// 공변성 : T' 가 T 의 하위 자료형이면 → C<T'> 는 C<T> 의 하위 자료형이다 [in 소비자 입장]
// 반공변성 :  T' 가 T 의 하위 자료형이면 → C<T> 는 C<T'> 의 하위 자료형이다 [out 생산자 입장]


/*  ▶ 무변성 Invariance
    형식 매개변수에 in 이나 out 등으로 공변성이나 반공변성을 따로 지정하지 않으면
    무변성 Invariance 으로 제네릭 클래스가 선언된다                                 */
class BoxInvariance<T>(val size: Int)


/*  ▶ 공변성 Covariance
    형식 매개변수의 상하 자료형 관계가 성립하고,
    그 관계가 그대로 인스턴스 자료형 관계로 이어지는 경우
    out 키워드 사용
    ex) Int 가 Any 의 하위 자료형일 때 형식 매개변수 T에 대해 공변적이라 한다    */
class BoxCovariance<out T>(val size: Int)


/*  ▶ 반공변성 Contravariance
    자료형의 상하 관계가 반대가 되어
    인스턴스의 자료형이 상위 자료형이 된다
    in 키워드 사용                                       */
class BoxContravariance<in T>(val size: Int)

fun main() {

    // 무변적 자료형 인스턴스
    //val anys1: BoxInvariance<Any> = BoxInvariance<Int>(10) // 오류 → 자료형 불일치
    //val nothings1: BoxInvariance<Nothing> = BoxInvariance<Int>(20) 오류 → 자료형 불일치

    // 공변적 자료형 인스턴스 → 하위 타입 관계를 유지
    val anys2: BoxCovariance<Any> = BoxCovariance<Int>(10)  // 관계 성립으로 객체 생성 가능
    //val nothings2: BoxCovariance<Nothing> = BoxCovariance<Int>(20)  // 오류 → 자료형 불일치

    // 반공변적 자료형 인스턴스 → 하위 타입 관계를 뒤집음
    //val anys3: BoxContravariance<Any> = BoxContravariance<Int>(10)  // 오류 → 자료형 불일치
    val nothings3: BoxContravariance<Nothing> = BoxContravariance<Int>(20)  // 관계 성립
}

