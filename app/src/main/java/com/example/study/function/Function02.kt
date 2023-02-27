package com.example.study.function

// ◆ 함수의 호출과 메모리 ◆

// 더 큰수를 반환하는 max 함수
fun max(a: Int, b: Int): Int {  // a 와 b 는 max() 함수의 임시 변수
    return if (a > b) a else b
}


// main() 함수에서 max 함수 호출
fun main() {                    // 최초의 스택 프레임
    val num1 = 10               // 임시 변수 혹은 지역 변수
    val num2 = 3                // 임시 변수 혹은 지역 변수
    val result: Int

    result = max(num1, num2)    // 두 번째 스택 프레임
    println("result : $result")

    // 프로그램이 실행되면 main() 함수가 가장 먼저 실행되고 중괄호로 감싼 본문 코드가 실행된다


    // ▶ 함수와 스택 프레임 ◀
    // 함수의 각 정보는 프레임(Frame) 이라는 정보로 스택(Stack) 영역의 높은 주소부터 거꾸로 자라듯이 채워져 간다

/*

--------- 스택과 각 함수의 스택 프레임 ---------

    ↓힙    낮은 주소

        [3  ← b
         10 ← a] max() 함수의 프레임

        [?  ← result
         3  ← num2
         10 ← num1
         0  ← args] main() 함수의 프레임

    ↑스택   높은 주소

------------------------------------------------

- main() 함수의 { } 안에 있는 지역 변수(args, num1. num2, result)는 첫 번째 스택 프레임에 있다.
  ※ 지역 변수(Local Variable)란 함수가 종료되면 스택 프레임과 함께 사라지는 임시 변수

- main() 함수에서 max() 함수가 호출되면 새로운 스택 프레임이 만들어진다
  max() 함수 스택 프레임에는 a, b의 값인 3, 10이 들어있다
  이 값을 이용하여 더 큰 수를 판단하고 그 값을 반환하며 함수는 종료된다
  함수가 종료되면 max() 함수의 스택 프레임이 소멸되며 반환값은 main() 함수의 result 변수에 저장된다


    ▶ 스택 프레임의 생성과 소멸 ◀

- 함수가 호출되면 스택에 프레임이 생긴다
  ex) main() 함수에서 max() 함수가 호출되면 max() 함수의 스택 프레임 생성
  스택 프레임은 각각 분리되어 있으므로 함수에 선언된 변수도 분리하여 생각한다

- 함수를 호출하면 위와 같은 방식으로 스택에 스택 프레임이 생성되며 생성한 순서의 반대 순서로 소멸된다
  예를 들어 함수 A(), B(), C() 를 순서대로 호출했다면
  3개의 스택 프레임이 아래에서 위로 생성되고 C(), B(), A() 순서로 스택에서 소멸된다

*/

}