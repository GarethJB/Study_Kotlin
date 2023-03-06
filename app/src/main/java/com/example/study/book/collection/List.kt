package com.example.study.book.collection




// ◆ List 활용하기 ◆

// List 는 순서에 따라 정렬된 요소를 가지는 컬렉션

// 불변형 List 를 만드려면 listOf() 를 사용할 수 있다
// 가변형 List 를 만드려면 mutableListOf() 를 사용한다
// 인자는 원하느 만큼의 가변 인자를 가지도록 vararg 로 선언한다


// MutableList 사용하기
fun main() {

    // 가변형 List 의 생성 및 추가, 삭제, 변경
    val mutableList: MutableList<String> = mutableListOf<String>("홍길동", "심청", "박문수")
    mutableList.add("Ben")  // 추가
    mutableList.removeAt(1) // index 1번 삭제
    mutableList[0] = "Sean" // index 0번을 변경, set 과 같은 역할
    println(mutableList)

    // 자료형의 혼합
    val mutableListMixed = mutableListOf("Android", "Apple", 5, 6, 'X')
    println(mutableListMixed)

    // 기존의 불변형 List 를 가변형으로 변경하려면 toMutableList() 를 사용할 수 있는데
    // 기존의 List 는 그대로 두고 새로운 공간을 만들어 낸다
    val names: List<String> = listOf("one", "two", "three") // 불변형 List 초기화
    val mutableNames = names.toMutableList()    // 새로운 가변형 List 가 만들어짐
    mutableNames.add("four")    // 가변형 List 에 하나의 요소 추가
    println(mutableNames)
}

