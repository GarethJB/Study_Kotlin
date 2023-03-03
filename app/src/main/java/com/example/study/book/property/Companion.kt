package com.example.study.book.property



// ◆ 컴패니언 객체 ◆

// 프로그램을 실행할 때 고정적으로 가지는 메모리
// 객체 생성 없이 사용할 수 있다
// 동적인 메모리에 할당 해제 되는 것이 아님
// 독립적으로 값을 가지고 있기 때문에 어떠한 객체라도 동일한 참조값을 가지고 있어
// 해당 클래스의 상태에 상관없이 접근할 수 있다 → 모든 객체에 의해 공유됨

class PersonCompanion {
    var id: Int = 0
    var name: String = "영덕"
    companion object {
        var language: String = "Korean"
        fun work() {
            println("working...")
        }
    }
}

fun main() {
    println(PersonCompanion.language)   // 인스턴스를 생성하지 않고 기본값 사용
    PersonCompanion.language = "English"    // 기본값 변경 가능
    println(PersonCompanion.language)   // 변경된 내용 출력
    PersonCompanion.work()  // 메소드 실행
    //println(PersonCompanion.name)   // name 은 컴패니언 객체가 아니므로 오류
}


// 자바코드와 연동해서 사용하기

// 코틀린에서 자바 클래스의 static 메소드 접근 → 객체 생성 없이 접근 가능
// 자바에서 코틀린 컴패니언 객체 사용 → @JvmStatic 어노테이션 표기 사용

/*  ※ @ 어노테이션이란?
    특수한 의미를 부여해 컴파일러가 목적에 맞추어 해석하도록 하거나
    실행(런타임)할 때 특정 기능을 수행하게 할 수 있다                   */





