package com.example.study.book.lambda

import java.util.concurrent.locks.ReentrantLock

// ◆ 고차함수와 람다식의 사례 ◆

// ▶ 동기화를 위한 코드 구현 ◀

/*
    동기화 (Synchronization)란
    변경이 일어나면 안 되는 특정 코드를 보호하기 위한 잠금 기법을 말한다

    동기화로 보호되는 코드는 임계영역 (Critical Section)이라고도 부른다
    보통 프로그래밍에서는 특정 공유 자원에 접근한다고 했을 때 공유 자원이 여러 요소에
    접근해서 망가지는 것을 막기 위해 임계영역의 코드를 잠가 두었다가 사용한 후 풀어 줘야 한다


    fun <T> lock(reLock: ReentrantLock, body: () -> T): T {
    reLock.lock()
    try {
        return body()
    } finally {
        reLock.unlock()
    }

    잠금을 위한 lock() 함수를 fun <T> lock() 형태인 제네릭(Generic) 함수로 설계하고 있다
    제네릭이란 데이터 자료형을 일반화해서 어떤 자료형이던 지정할 수 있는 자료형이다
    함수 반환값에 대해 어떤 자료형이든 지정될 수 있다

    ※ T는 제네릭의 형식 파라미터라고 하며 임의의 참조 자료형을 의미한다.
       형식 파라미터는 다양한 자료형을 처리하는데 클래스뿐만 아니라 메소드 파라미터나 반환값으로도 사용할 수 있다

    try{} 의 모든 내용이 처리된 후 finally{} 을 처리한다
    만약 try{} 블록에 문제가 발생해도 finally{} 블록은 항상 수행
    try{} 블록에서는 주로 메모리 할당이나 파일 열기 같은 작업을 수행
    finally{} 에서는 무언가 해제하거나 닫는 작업을 수행

*/

var sharable = 1    // 보호가 필요한 공유 자원

fun main() {
    val reLock = ReentrantLock()
    lock(reLock, { criticalFunc() })
    lock(reLock) { criticalFunc() }
    lock(reLock, ::criticalFunc)

    println(sharable)
}

fun criticalFunc() {
    // 공유 자원 접근 코드 사용
    sharable += 1
}

fun <T> lock(reLock: ReentrantLock, body:() -> T): T {
    reLock.lock()
    try {
        return body()
    } finally {
        reLock.unlock()
    }
}

//  이 함수에 criticalFunc()을 두 번째 인자로 넘겨서 처리하면
//  람다식 함수의 파라미터인 body 에 의해 잠금 구간에서
//  sharable 변수가 다른 루틴의 방해 없이 안전하게 처리된다

