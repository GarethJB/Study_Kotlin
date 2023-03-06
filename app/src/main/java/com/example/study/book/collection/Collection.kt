package com.example.study.book.collection



// ◆ 코틀린의 컬렉션 ◆

/*  - 컬렉션이란?
    자주 사용하는 기초적인 자료구조를 모아 놓은 일종의 프레임워크로 표준 라이브러리로 제공되고 있다   */

// ▶ 코틀린의 컬렉션

// 코틀린의 컬렉션은 자바 컬렉션의 구조를 확장 구현했다

// 자바와는 다르게 가변형 mutable 과 불변형 immutable 로 나뉜다

// 가변형 컬렉션은 객체에 데이터를 추가하거나 변경할 수 있다
// 불변형 컬렉션은 데이터를 한 번 할당하면 읽기 전용이 된다

/*  컬렉션의 불변형/가변형 자료형 분류와 그에 따른 생성 헬퍼 함수

    - List
    불변형 : listOf
    가변형 : mutableListOf, arrayListOf

    - Set
    불변형 : setOf
    가변형 : mutableSetIf, hashSetOf, linkedSetOf, sortedSetOf

    - Map
    불변형 : mapOf
    가변형 : mutableMapOf, hashMapOf, linkedMapOf, sortedMapOf             */



/*  Collection 인터페이스의 멤버

    size → 컬렉션의 크기를 나타낸다
    isEmpty() → 컬렉션이 비어 있으면 true 를 반환한다
    contains(element: E) → 특정 요소가 있다면 true 를 반환한다
    containsAll(elements: Collection<E>) → 인자로 받아들인 컬렉션이 있다면 true 를 반환한다    */


/*  MutableCollection 인터페이스의 멤버 메소드

    add(element: E) → 인자로 전달 받은 요소를 추가하고 true 를 반환하며,
                       이미 요소가 있거나 중복이 허영되지 않으면 false 를 반환한다
    remove(element: E) → 인자로 전달 받은 요소를 삭제하고 true 를 반환하며,
                          삭제하려는 요소가 없다면 false 를 반환한다
    addAll(elements: Collection<E>) → 컬렉션을 인자로 전달 받아 모든 요소를 추가하고
                                       true 를 반환하며, 실패하면 false 를 반환한다
    removeAll(elements: Collection<E>) → 컬렉션을 인자로 전달 받아 모든 요소를 삭제하고
                                          true 를 반환하며, 실패하면 false 를 반환한다
    retainAll(elements: Collection<E>) → 인자로 전달 받은 컬렉션의 요소만 보유한다.
                                          성공하면 true , 실패하면 false 를 반환한다
    clear() → 컬렉션의 모든 요소를 삭제한다                                                      */






