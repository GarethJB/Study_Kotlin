package com.example.study.operator

fun main() {

    // ◆ 기본 연산자 ◆
    // 코틀린의 기본 연산자는 산술, 대입, 증가, 감소, 비교, 논리 연산자 등이 있다


    // ▶ 수식의 구조 ◀
    val num1 = 1
    val num2 = 2
    val result = num1 + num2
    // + 는 산술 연산자, num1, num2 와 같이 연산에 사용되는 값은 항
    // 연산자는 항의 개수에 따라서 단한 연산자, 이항 연산자, 삼항 연산자로 구분


    // ▶ 산술 연산자 ◀
    // 산술연산자는 + - * / % 가 있다
    // 나머지 연산의 활용
    var n = 4
    if ((n % 2) == 1) {
        println("n is an Odd number")   // 홀수
    }else if ((n % 2) == 0) {
        println("n is an Even number")  // 짝수
    }


    // ▶ 대입 연산자 ◀
    // 대입연산자 = 는 변수에 값을 할당하는 연산자다
    // 대입 연산자는 이항 연산자 중 우선순위가 가장 낮다 → 모든 연산이 끝나면 동작
    val numOfApple = 12 // 변수가 대입 연산자에 의해 할당됨
    val resultApple = numOfApple - 2    // 표현식이 대입 연산자에 의해 결과값 할당

    // 연산을 수행한 다음 결과값을 다시 변수에 할당할 때 간결하게 표현할 수 있다
    var num3 = 1
    num3 += 2   // num3 = num3 + 2

    // = : 오른쪽 항의 내용을 왼쪽 항에 대입
    // += : 두 항을 더한 후 왼쪽 항에 대입
    // -= : 왼쪽 항을 오른쪽 항으로 뺀 후 왼쪽 항에 대입
    // *= : 두 항을 곱한 후 왼쪽 항에 대입
    // /= : 왼쪽 항을 오른쪽 항으로 나눈 후 왼쪽 항에 대입
    // %= : 왼쪽 항을 오른쪽 항으로 나머지 연산 후 왼쪽 항에 대입


    // ▶ 증가 연산자와 감소 연산자 ◀
    // 항의 앞이나 뒤에 붙여 사용하며 1을 더하거나 빼는 연산을 수행

    // ++ : 항의 값에 1 증가
    // -- : 항의 값에 1 감소
    var num4 = 10
    var num5 = 10

    val resultNum4 = ++num4 // num4 값 증가 후 대입
    val resultNum5 = num5++ // 먼저 num5 값 대입 후 증가

    println("resultNum4 : $resultNum4")
    println("resultNum5 : $resultNum5")

    println("num4 : $num4")
    println("num5 : $num5")



    // ▶ 삼중 등호 연산자 ◀
    // === : 2개 항의 참조 주소가 같으면 true, 아니면 false
    // !== : 2개 항의 참조 주소가 다르면 true, 아니면 false


}