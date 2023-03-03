package com.example.study.book.classandinterface



// ◆ 실드 클래스 ◆

// 미리 만들어 놓은 자료형들을 묶어서 제공
// sealed 키워드를 class 와 함께 사용
// 실드 클래스 자체는 추상클래스와 같으므로 객체를 만들 수는 없다
// 생성자도 기본적으로 private 이며 private 가 아닌 생성자는 허용하지 않음
// 같은 파일 안에서는 상속이 가능하지만, 다른 파일에서는 불가능

// 실드 클래스 선언 방법 ①
sealed class Result1 {
    open class Success(val message: String): Result1()
    class Error(val code: Int, val message: String): Result1()
}

class Status1: Result1()  // 실드 클래스 상속은 같은 파일에서만 가능
class Inside1: Result1.Success("Status")  // 내부 클래스 상속


// 실드 클래스 선언 방법 ②
sealed class Result2

open class Success(val message: String): Result2()
class Error(val code: Int, val message: String): Result2()

class Status2: Result2()
class Inside2: Success("Status")


// 실드 클래스는 특정 객체 자료형에 따라
// when 과 is 에 의해 선택적으로 실행할 수 있다
// 필요한 경우의 수를 직접 지정할 수 있다

