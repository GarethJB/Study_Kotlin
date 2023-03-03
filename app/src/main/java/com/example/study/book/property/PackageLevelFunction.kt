// 접근할 클래스를 바꾸고 싶을 때
@file:JvmName("FileName")
package com.example.study.book.property



// ◆ 최상위 함수 사용 ◆

// 최상위 함수는 객체 생성 없이 어디서든 사용할 수 있다 → ex) main() 함수

fun packageLevelFunc() {
    println("Package-Level Function")
}   // 최상위 함수는 JVM 에서 실행되기 위해 static 으로 선언되어 있다

fun main() {
    packageLevelFunc()
}


